package signalr.kt.impls

import signalr.kt.abstract.HubMessage
import signalr.kt.enums.HubMessageType

data class PingMessage(override val MessageType: HubMessageType = HubMessageType.PING) :
        HubMessage()
