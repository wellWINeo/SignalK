package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class StreamItem(
        val Headers: Map<String, String>,
        val InvocationId: String,
        val Item: Any,
        override val MessageType: HubMessageType = HubMessageType.STREAM_ITEM
) : HubMessage()
