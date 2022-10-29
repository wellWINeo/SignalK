package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class InvocationBindingFailureMessage(
        override val MessageType: HubMessageType = HubMessageType.INVOCATION_BINDING_FAILURE,
        val InvocationId: String,
        val Target: String,
        val Exception: Exception
) : HubMessage()
