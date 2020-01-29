package com.project.encryptutils

import com.project.encryptutils.hash.*
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class HashTest {
    @Test
    fun testSHA() {
        testHashing(SHA1)
    }

    @Test
    fun testSHA224() {
        testHashing(SHA224)
    }

    @Test
    fun testSHA256() {
        testHashing(SHA256)
    }

    @Test
    fun testSHA384() {
        testHashing(SHA384)
    }

    @Test
    fun testSHA512() {
        testHashing(SHA512)
    }

    @Test
    fun testMD2() {
        testHashing(MD2)
    }

    @Test
    fun testMD5() {
        testHashing(MD5)
    }

    private fun testHashing(helper: HashHelper) {
        assertArrayEquals(helper.hash(DATA), helper.hash(DATA))
        assertArrayEquals(helper.hash(DATA.toByteArray()), helper.hash(DATA.toByteArray()))
        assertArrayEquals(helper.hash(DATA.toByteArray(Charsets.US_ASCII)), helper.hash(DATA.toByteArray(Charsets.US_ASCII)))
        assertNotEquals(helper.hash(DATA).contentToString(), helper.hash(DATA.toByteArray(Charsets.UTF_16BE)).contentToString())
    }

    private companion object {
        private const val DATA = "Hello world, I'm some random phrase"
    }
}