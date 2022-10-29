package signalr.kt.impls

data class HttpResponse(
    var statusCode: Int,
    var statusText: String,
    var content: ByteArray,
)