package signalr.kt

import io.reactivex.rxjava3.core.Single
import signalr.*
import signalr.enum.TransportType
import signalr.kt.*
import signalr.kt.abstract.HubProtocol
import signalr.kt.enum.ITransport

class HubConnection(
        val url: String,
        val transport: ITransport? = null,
        val skipNegotiate: Boolean,
        val httpClient: HttpClient? = DefaultHttpClient(),
        val protocol: HubProtocol? = null,
        var accessTokenProvider: Single<String> = Single.just(""),
        val handshakeResponseTimeout: Long = 15 * 1000L,
        val headers: Map<String, String> = HashMap(),
        var transportType: TransportType = TransportType.ALL,
// TODO: confugreBuilder:
// https://github.com/dotnet/aspnetcore/blob/9c8520aac960a9933a1e63e0f06385572d48e94c/src/SignalR/clients/java/signalr/core/src/main/java/com/microsoft/signalr/HubConnection.java#L123
) : AutoCloseable {
    // private val RECORD_SEPARATOR: Byte = 0x1e
    // private val MAX_NEGOTIATE_ATTEMPTS: Int = 100
    // private val emptyArray: List<Type> = ArrayList()

    // private val handlers: CallbackMap = CallbackMap()
    // private val negotiateVersion: Int = 1
    // private val customTransport: ITransport
    // private val callback: IOnReceiveCallback

    // //
    // var serverTimeout: Long = 30 * 1000
    // var keepAliveInterval: Long = 15 * 1000

    // //
    // private val baseUrl: String
    // private val onClosedCallbacks: List<IOnCloseCallback>

    // // TODO: implement reconnecting
    // // ReconnectingConnectionState

    // init {
    //     if (url.isEmpty())
    //         throw IllegalArgumentException("A valid url is required")

    // }

    // private fun handleNegotiate(url: String, localHeaders: Map<String, String>):
    // Single<NegotiateResponse> {

    // }

    // fun getConnectionId(): String {
    //     throw NotImplementedError("")
    // }

    override fun close() {
        TODO("Not yet implemented")
    }
}
