package com.inscreen.sdkserver

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.security.SecureRandom
import java.util.Arrays
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

class InScreenSDK(val apiKey: String) {
    val random = SecureRandom()
    val key = SecretKeySpec(Base64.getUrlDecoder().decode(apiKey), "AES")

    fun createToken(session: InScreenSession): String {
        val IV = ByteArray(12)
        random.nextBytes(IV)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, key, GCMParameterSpec(16 * 8, IV))

        val sessionString = Json.encodeToString(session)
        val cipherText = cipher.doFinal(sessionString.toByteArray())
        val baseCipherText = Arrays.copyOfRange(cipherText, 0, cipherText.size - 16)
        val authTag = Arrays.copyOfRange(cipherText, cipherText.size - 16, cipherText.size)

        val encoder = Base64.getUrlEncoder().withoutPadding()
        return encoder.encodeToString(IV) + encoder.encodeToString(authTag) + encoder.encodeToString(baseCipherText)
    }
}
