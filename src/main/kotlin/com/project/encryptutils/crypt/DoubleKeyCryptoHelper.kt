package com.project.encryptutils.crypt

import java.security.KeyPair
import javax.crypto.Cipher

/**
 * Implementation of [CryptoHelper] for algorithms with two keys.
 * Subclasses can generate default keys with their own key size.
 * Currently there is only one implementation: [RSA], because
 * [Cipher] provides only RSA algorithm for public-key encryption,
 * but developer can add other implementation if he can.
 *
 * @param algorithmName name of algorithm to use
 * @param keyPair pair of public (for encryption) and private (for decryption) key
 */
open class DoubleKeyCryptoHelper(
    algorithmName: String,
    keyPair: KeyPair
) : CryptoHelper {

    private val encryptCipher = Cipher.getInstance(algorithmName)
    private val decryptCipher = Cipher.getInstance(algorithmName)

    init {
        encryptCipher.init(Cipher.ENCRYPT_MODE, keyPair.public)
        decryptCipher.init(Cipher.DECRYPT_MODE, keyPair.private)
    }

    final override fun encrypt(data: ByteArray): ByteArray = encryptCipher.doFinal(data)

    final override fun decrypt(data: ByteArray): ByteArray = decryptCipher.doFinal(data)
}