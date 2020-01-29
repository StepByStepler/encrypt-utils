package com.project.encryptutils.crypt

import javax.crypto.Cipher
import javax.crypto.SecretKey

/**
 * Implementation of [CryptoHelper] for algorithms with single key.
 * Subclasses can generate default keys with their own key size.
 *
 * @param algorithmName name of algorithm to use
 * @param key secret key used in initiating [Cipher]
 */
open class SingleKeyCryptoHelper(
    algorithmName: String,
    key: SecretKey
) : CryptoHelper {

    private val encryptCipher = Cipher.getInstance(algorithmName)
    private val decryptCipher = Cipher.getInstance(algorithmName)

    init {
        encryptCipher.init(Cipher.ENCRYPT_MODE, key)
        decryptCipher.init(Cipher.DECRYPT_MODE, key)
    }

    final override fun encrypt(data: ByteArray): ByteArray = encryptCipher.doFinal(data)

    final override fun decrypt(data: ByteArray): ByteArray = decryptCipher.doFinal(data)
}