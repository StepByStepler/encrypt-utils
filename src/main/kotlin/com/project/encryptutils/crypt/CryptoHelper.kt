package com.project.encryptutils.crypt

import java.security.Key
import javax.crypto.Cipher

/**
 * Represents abstraction layer over different encryption
 * and decryption algorithms implemented in Java with [Cipher].
 * It helps developer with:
 * - Type safety: instead of getting algorithm by it's name,
 *   developer can get algorithm with class name which is
 *   checked at compile time. For example: Instead of writing
 *   `Cipher.getInstance("AES").foo()` one can use `AES.foo()`.
 * - Avoiding boilerplate code when creating instances of [Cipher] and [Key]
 * - Minor performance improvement: instead of looking up [Cipher]
 *    every time, which can slow up a bit, developer can access cached
 *    Cipher without any lookup.
 */
interface CryptoHelper {
    /**
     * Encrypt given [data] according to algorithm implementation
     *
     * @param data data which needs to be encrypted
     * @return byte array of encrypted data
     */
    fun encrypt(data: ByteArray): ByteArray

    /**
     * Decrypt given encrypted [data] according to algorithm implementation
     *
     * @param data encrypted data which needs to be decrypted
     * @return data after decryption
     */
    fun decrypt(data: ByteArray): ByteArray
}