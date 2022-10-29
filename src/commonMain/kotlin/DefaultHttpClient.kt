package signalr.kt

import io.ktor.client.statement.HttpResponse as KtorHttpResponse
import io.ktor.client.HttpClient as KtorHttpClient
import io.ktor.http.HttpMethod as KtorHttpMethod
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import signalr.kt.abstract.WebSocketWrapper
import signalr.kt.enums.HttpMethod
import signalr.kt.impls.HttpRequest
import signalr.kt.impls.HttpResponse

class DefaultHttpClient : HttpClient() {
    private var client: KtorHttpClient? = null

    init {
        this.client = KtorHttpClient(CIO)
    }

    override suspend fun send(request: HttpRequest): HttpResponse = this.send(request, null)

    override suspend fun send(request: HttpRequest, body: ByteArray?): HttpResponse {
        val resp: KtorHttpResponse = this.client?.request(request.url) {
            method = when (request.method) {
                HttpMethod.GET -> KtorHttpMethod.Get
                HttpMethod.POST -> KtorHttpMethod.Post
                HttpMethod.DELETE -> KtorHttpMethod.Delete
                else -> throw IllegalStateException()
            }

            if (body != null) {
                contentType(ContentType.Text.Plain)
                setBody(body)
            }

            headers {
                request.headers.forEach { append(it.key, it.value) }
            }
        } ?: throw HttpClientException()

        return HttpResponse(resp.status.value, resp.status.description, resp.body())
    }

    override fun createWebSocket(url: String, headers: Map<String, String>): WebSocketWrapper {
        TODO("Not yet implemented")
    }

    override fun cloneWithTimeOut(timeoutInMilliseconds: Int): HttpClient {
        TODO("Not yet implemented")
    }

    override fun close() {
        this.client?.close()
    }
}
