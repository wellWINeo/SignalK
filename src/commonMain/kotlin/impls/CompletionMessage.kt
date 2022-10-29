package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class CompletionMessage(
        val Headers: Map<String, String>,
        val InvocationId: String,
        val Result: Any?,
        val Error: String?,
        override val MessageType: HubMessageType = HubMessageType.COMPLETION
) : HubMessage()
