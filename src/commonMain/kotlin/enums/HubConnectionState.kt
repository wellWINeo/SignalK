package signalr.kt.enums

/**
 * Indicates the state of the {@link HubConnection}
 */
enum class HubConnectionState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    DISCONNECTING,
    RECONNECTING,
}