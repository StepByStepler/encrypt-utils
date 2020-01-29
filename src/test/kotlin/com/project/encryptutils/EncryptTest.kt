package com.project.encryptutils

import com.project.encryptutils.crypt.*
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import kotlin.text.Charsets.US_ASCII
import kotlin.text.Charsets.UTF_16BE

class EncryptTest {
    @Test
    fun testAES() {
        testSingleKeyEncrypting(AES())
    }

    @Test
    fun testDES() {
        testSingleKeyEncrypting(DES())
    }

    @Test
    fun testBlowfish() {
        testSingleKeyEncrypting(Blowfish())
    }

    @Test
    fun testRC2() {
        testSingleKeyEncrypting(RC2())
    }

    @Test
    fun testRSA() {
        testEncrypting(RSA())
    }

    private fun testSingleKeyEncrypting(helper: CryptoHelper) {
        val encrypted = helper.encrypt(DATA)
        assertArrayEquals(helper.encrypt(encrypted), helper.encrypt(encrypted))
        assertArrayEquals(helper.encrypt(DATA), helper.encrypt(DATA))
        assertArrayEquals(helper.encrypt(DATA.toByteArray()), helper.encrypt(DATA.toByteArray()))
        assertArrayEquals(helper.encrypt(DATA.toByteArray(US_ASCII)), helper.encrypt(DATA.toByteArray(US_ASCII)))
        assertArrayEquals(helper.encrypt(helper.decrypt(encrypted)), encrypted)
        testEncrypting(helper)
    }

    private fun testEncrypting(helper: CryptoHelper) {
        assertArrayEquals(helper.decrypt(helper.encrypt(DATA)), DATA.toByteArray())
        assertNotEquals(helper.encrypt(DATA).contentToString(), helper.encrypt(DATA.toByteArray(UTF_16BE)).contentToString())
    }

    private companion object {
        private const val DATA = "Hello world, I'm some random phrase"
    }
}