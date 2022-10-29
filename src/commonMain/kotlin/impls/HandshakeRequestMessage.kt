package signalr.kt.impls

import kotlinx.serialization.Serializable

@Serializable data class HandshakeRequestMessage(val Protocol: String, val Version: Int)
