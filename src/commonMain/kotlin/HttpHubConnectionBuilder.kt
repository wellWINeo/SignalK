package signalr.kt

import signalr.enum.TransportType
import signalr.kt.abstract.HubProtocol
import signalr.kt.enum.ITransport

class HttpHubConnectionBuilder(val url: String) {
    private var transportType: TransportType = TransportType.ALL
    private val transport: ITransport? = null
    private var protocol: HubProtocol? = null
    private var skipNegotiate: Boolean = false
    private var accessTokenProvider: String = ""
    private var handshakeResponseTimeout: Long = 0
    private var headers: MutableMap<String, String> = mutableMapOf()
    private var httpClient: HttpClient? = null

    /**
     * Sets the transport type to indicate which transport to be used by the {@link HubConnection}.
     *
     * @param transportType The type of transport to be used.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withTransport(transportType: TransportType): HttpHubConnectionBuilder {
        this.transportType = transportType
        return this
    }

    /**
     * Sets the [HttpClient] to be used by the [HubConnection].
     *
     * @param httpClient The [HttpClient] to be used by the [HubConnection].
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withHttpClient(httpClient: HttpClient): HttpHubConnectionBuilder {
        this.httpClient = httpClient
        return this
    }

    /**
     * Sets the [HubProtocol] to be used by the [HubConnection].
     *
     * @param protocol The [HubProtocol] to be used by the [HubConnection].
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withHubProtocol(protocol: HubProtocol): HttpHubConnectionBuilder {
        this.protocol = protocol
        return this
    }

    /**
     * Indicates to the [HubConnection] that it should skip the negotiate process.
     * Note: This option only works with the [TransportType.WEBSOCKETS] transport selected via [withTransport][.withTransport],
     * additionally the Azure SignalR Service requires the negotiate step so this will fail when using the Azure SignalR Service.
     *
     * @param skipNegotiate Boolean indicating if the [HubConnection] should skip the negotiate step.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun shouldSkipNegotiate(skipNegotiate: Boolean): HttpHubConnectionBuilder {
        this.skipNegotiate = skipNegotiate
        return this
    }

    /**
     * Sets the access token provider for the [HubConnection].
     *
     * @param accessTokenProvider The access token provider to be used by the [HubConnection].
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withAccessTokenProvider(accessTokenProvider: Single<String>): HttpHubConnectionBuilder {
        this.accessTokenProvider = accessTokenProvider
        return this
    }

    /**
     * Sets the duration the [HubConnection] should wait for a Handshake Response from the server.
     *
     * @param timeoutInMilliseconds The duration (specified in milliseconds) that the [HubConnection] should wait for a Handshake Response from the server.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withHandshakeResponseTimeout(timeoutInMilliseconds: Long): HttpHubConnectionBuilder {
        this.handshakeResponseTimeout = timeoutInMilliseconds
        return this
    }

    /**
     * Sets a collection of Headers for the [HubConnection] to send with every Http request.
     *
     * @param headers A Map representing the collection of Headers that the [HubConnection] should send.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withHeaders(headers: Map<String, String>): HttpHubConnectionBuilder {
        this.headers = headers.toMutableMap()
        return this
    }

    /**
     * Sets a single header for the {@link HubConnection} to send.
     *
     * @param name The name of the header to set.
     * @param value The value of the header to be set.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    fun withHeader(name: String, value: String): HttpHubConnectionBuilder {
        this.headers[name] = value
        return this
    }

    fun build(): HubConnection {
        return HubConnection(
            url,
            transport,
            skipNegotiate,
            httpClient,
            protocol,
            accessTokenProvider,
            handshakeResponseTimeout,
            headers,
            transportType
        )
    }

}