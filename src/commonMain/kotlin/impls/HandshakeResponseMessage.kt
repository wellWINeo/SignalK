package signalr.kt.impls

import kotlinx.serialization.Serializable

@Serializable data class HandshakeResponseMessage(val Error: String)
