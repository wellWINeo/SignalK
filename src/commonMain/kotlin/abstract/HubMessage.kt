package signalr.kt.abstract

import signalr.kt.enums.HubMessageType

abstract class HubMessage {
    abstract val MessageType: HubMessageType
}
