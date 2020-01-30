package com.project.encryptutils.crypt

import java.security.KeyPair
import javax.crypto.Cipher

/**
 * RSA encryption algorithm - the only available in
 * [Cipher] for public-key encryption.
 */
class RSA(
    keyPair: KeyPair = generateRandomKeyPair("RSA", 2048)
) : DoubleKeyCryptoHelper("RSA", keyPair)