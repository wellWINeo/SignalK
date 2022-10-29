package signalr.kt

import signalr.kt.abstract.WebSocketWrapper
import signalr.kt.enums.HttpMethod
import signalr.kt.impls.HttpRequest
import signalr.kt.impls.HttpResponse

abstract class HttpClient {

    suspend fun get(url: String): HttpResponse = this.send(HttpRequest(HttpMethod.GET, url))

    suspend fun get(url: String, options: HttpRequest): HttpResponse =
            this.invoke(HttpMethod.GET, url, options)

    suspend fun post(url: String): HttpResponse = this.send(HttpRequest(HttpMethod.POST, url))

    suspend fun post(url: String, body: ByteArray, options: HttpRequest): HttpResponse =
        this.send(HttpRequest(HttpMethod.POST, url), body)

    suspend fun post(url: String, options: HttpRequest): HttpResponse =
        this.invoke(HttpMethod.POST, url, options)

    suspend fun delete(url: String): HttpResponse = this.send(HttpRequest(HttpMethod.DELETE, url))

    suspend fun delete(url: String, options: HttpRequest): HttpResponse =
            this.invoke(HttpMethod.DELETE, url, options)

    private suspend fun invoke(
            method: HttpMethod,
            url: String,
            options: HttpRequest
    ): HttpResponse {
        options.method = method
        options.url = url
        return this.send(options)
    }

    abstract suspend fun send(request: HttpRequest): HttpResponse
    abstract suspend fun send(request: HttpRequest, body: ByteArray? = null): HttpResponse
    abstract fun createWebSocket(url: String, headers: Map<String, String>): WebSocketWrapper
    abstract fun cloneWithTimeOut(timeoutInMilliseconds: Int): HttpClient
    abstract fun close()
}
