package com.project.encryptutils.hash

import java.security.MessageDigest

/**
 * Represents adapter over HashHelper which accepts [algorithmName]
 * in it's constructor. Then it looks up [MessageDigest] by [algorithmName]
 * and uses it to hash data.
 */
open class HashHelperAdapter(algorithmName: String) : HashHelper {
    private val messageDigest = MessageDigest.getInstance(algorithmName)

    final override fun hash(data: ByteArray): ByteArray {
        return messageDigest.digest(data)
    }
}