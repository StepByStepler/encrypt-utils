package com.project.encryptutils.hash

import java.nio.charset.Charset

/**
 * Performs hashing of given [text] encoded with given [charset]
 *
 * @param text text which needs to be hashed
 * @param charset charset of given text
 * @return byte array of hashed [text]
 */
fun HashHelper.hash(text: String, charset: Charset = Charsets.UTF_8): ByteArray {
    return hash(text.toByteArray(charset))
}