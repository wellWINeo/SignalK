package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class InvocationMessage(
        val Header: Map<String, String>,
        val InvocationId: String,
        val Target: String,
        val Arguments: Iterable<Any>,
        val StreamIds: Collection<String>,
        override val MessageType: HubMessageType = HubMessageType.INVOCATION
) : HubMessage()
