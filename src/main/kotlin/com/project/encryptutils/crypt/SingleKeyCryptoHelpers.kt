package com.project.encryptutils.crypt

import com.project.encryptutils.generateRandomSecretKey
import javax.crypto.SecretKey

/**
 * AES-256 encryption algorithm.
 */
class AES(
    key: SecretKey = generateRandomSecretKey("AES", 256)
) : SingleKeyCryptoHelper("AES", key)

/**
 * DES encryption algorithm.
 */
class DES(
    key: SecretKey = generateRandomSecretKey("DES", 56)
) : SingleKeyCryptoHelper("DES", key)

/**
 * Blowfish encryption algorithm.
 */
class Blowfish(
    key: SecretKey = generateRandomSecretKey("Blowfish", 448)
) : SingleKeyCryptoHelper("Blowfish", key)

/**
 * RC2 encryption algorithm.
 */
class RC2(
    key: SecretKey = generateRandomSecretKey("RC2", 64)
) : SingleKeyCryptoHelper("RC2", key)