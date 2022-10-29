package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class StreamInvocationMessage(
        val Header: Map<String, String>,
        val InvocationId: String,
        val Target: String,
        val Arguments: Iterable<Any>,
        val StreamIds: Collection<String>,
        override val MessageType: HubMessageType = HubMessageType.STREAM_INVOCATION
) : HubMessage()
