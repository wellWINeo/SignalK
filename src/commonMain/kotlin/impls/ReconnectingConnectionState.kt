package signalr.kt.impls

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import signalr.kt.enums.HubConnectionState

// TODO
// Not fully implemented
// Just rewritten from Java implementation
internal class ReconnectingConnectionState {
    private var _connectionState: ConnectionState? = null
    var connectionState: ConnectionState?
        get() {
            return runBlocking {
                mutex.withLock {
                    _connectionState
                }
            }
        }
        set(value) {
            runBlocking {
                mutex.withLock {
                    _connectionState = value
                }
            }
        }
    var hubConnectionState = HubConnectionState.DISCONNECTED
        private set
    private val mutex = Mutex()

    suspend fun changeState(from: HubConnectionState, to: HubConnectionState) {
        this.mutex.withLock {
            if (this.hubConnectionState != from)
                throw RuntimeException(
                    "The HubConnection failed to transition from the '$from' state to the '$to' state because it was actually in the '$hubConnectionState' state."
                )
            this.hubConnectionState = to
        }
    }

    suspend fun changeState(to: HubConnectionState) {
        this.mutex.withLock {
            this.hubConnectionState = to
        }
    }

    suspend fun lock() {
        this.mutex.lock()
    }

    fun unlock() {
        this.mutex.unlock()
    }

}