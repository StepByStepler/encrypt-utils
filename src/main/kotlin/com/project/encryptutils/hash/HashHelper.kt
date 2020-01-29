package com.project.encryptutils.hash

import java.security.MessageDigest

/**
 * Represents abstraction layer over different hashing
 * algorithms implemented in Java with [MessageDigest].
 * It helps developer with:
 * - Type safety: instead of getting algorithm by it's name,
 *   developer can get algorithm with class name which is
 *   checked at compile time. For example: Instead of writing
 *   `MessageDigest.getInstance("MD5").foo()` one can use `MD5.foo()`.
 * - Minor performance improvement: instead of looking up [MessageDigest]
 *    every time, which can slow up a bit, developer can access cached
 *    [MessageDigest] without any lookup.
 */
interface HashHelper {
    /**
     * Performs hashing of given [data] with implemented algorithm.
     *
     * @param data bytes which needs to be hashed
     * @return byte array of hashed data
     */
    fun hash(data: ByteArray): ByteArray
}