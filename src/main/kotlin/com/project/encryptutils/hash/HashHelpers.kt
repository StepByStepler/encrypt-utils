package com.project.encryptutils.hash

/**
 * All available hashing algorithms available in Java SE.
 */

/**
 * SHA-1 hash algorithm.
 */
object SHA1: HashHelperAdapter("SHA-1")

/**
 * SHA-224 hash algorithm.
 */
object SHA224 : HashHelperAdapter("SHA-224")

/**
 * SHA-256 hash algorithm.
 */
object SHA256 : HashHelperAdapter("SHA-256")

/**
 * SHA-384 hash algorithm.
 */
object SHA384 : HashHelperAdapter("SHA-384")

/**
 * SHA-512 hash algorithm.
 */
object SHA512 : HashHelperAdapter("SHA-512")

/**
 * MD2 hash algorithm.
 */
object MD2 : HashHelperAdapter("MD2")

/**
 * MD5 hash algorithm.
 */
object MD5 : HashHelperAdapter("MD5")

