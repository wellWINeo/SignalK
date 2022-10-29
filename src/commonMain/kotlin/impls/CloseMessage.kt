package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class CloseMessage(
        val Error: String? = null,
        val AllowReconnect: Boolean = false,
        override val MessageType: HubMessageType = HubMessageType.CLOSE
) : HubMessage()
