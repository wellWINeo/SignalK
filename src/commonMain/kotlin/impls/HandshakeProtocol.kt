package signalr.kt.impls

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

public object HandshakeProtocol {
    private val RECORD_SEPARATOR = "\u001e"

    fun createHandshakeRequestMessage(message: HandshakeRequestMessage): ByteArray {
        return (Json.encodeToString(message) + RECORD_SEPARATOR).toByteArray()
    }

    fun parseHandshakeResponse(message: String): HandshakeResponseMessage {
        return Json.decodeFromString<HandshakeResponseMessage>(message)
    }
}
