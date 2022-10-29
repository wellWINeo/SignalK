package signalr.kt.enums

enum class HubMessageType(val value: Int) {
    INVOCATION(1),
    STREAM_ITEM(2),
    COMPLETION(3),
    STREAM_INVOCATION(4),
    CANCEL_INVOCATION(5),
    PING(6),
    CLOSE(7),
    INVOCATION_BINDING_FAILURE(-1),
    STREAM_BINDING_FAILURE(-2)
}
