package com.project.encryptutils

import com.project.encryptutils.crypt.CryptoHelper
import java.nio.charset.Charset
import java.security.KeyPair
import java.security.KeyPairGenerator
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * Encrypts given [data] in given [charset] to ByteArray.
 *
 * @param data text to encrypt
 * @param charset charset of text
 * @return byte array of encrypted data
 */
fun CryptoHelper.encrypt(data: String, charset: Charset = Charsets.UTF_8): ByteArray {
    return encrypt(data.toByteArray(charset))
}

/**
 * Decrypts given [data] and decodes it to String in given [charset].
 *
 * @param data encrypted data which needs to be decrypted
 * @param charset charset of text
 * @return decrypted text in given [charset]
 */
fun CryptoHelper.decryptToString(data: ByteArray, charset: Charset = Charsets.UTF_8): String {
    return decrypt(data).toString(charset)
}

/**
 * Generates random secret key for given [algorithmName] with size [sizeBits].
 *
 * @param algorithmName name of algorithm which uses this key
 * @param sizeBits size of key in bits
 * @return generated key
 */
fun generateRandomSecretKey(algorithmName: String, sizeBits: Int): SecretKey {
    val keyGenerator = KeyGenerator.getInstance(algorithmName)
    keyGenerator.init(sizeBits)
    return keyGenerator.generateKey()
}

/**
 * Generates random pair of private and public key used by encryption
 * algorithms with double keys.
 *
 * @param algorithmName name of algorithm which uses this pair of keys
 * @param sizeBits size of each resulting key
 */
fun generateRandomKeyPair(algorithmName: String, sizeBits: Int): KeyPair {
    val keyPairGenerator = KeyPairGenerator.getInstance(algorithmName)
    keyPairGenerator.initialize(sizeBits)
    return keyPairGenerator.genKeyPair()
}