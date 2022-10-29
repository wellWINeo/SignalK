package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class StreamingBindingFailure(
        override val MessageType: HubMessageType = HubMessageType.STREAM_BINDING_FAILURE,
        val InvocationId: String,
        val Exception: Exception,
) : HubMessage()
