package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class CancelInvocationMessage(
        val Headers: Map<String, String>,
        val InvocationId: String,
        override val MessageType: HubMessageType = HubMessageType.CANCEL_INVOCATION
) : HubMessage()
