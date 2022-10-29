package signalr.kt.impls

import signalr.kt.enums.HttpMethod

data class HttpRequest(
    var method: HttpMethod,
    var url :String,
    var headers: Map<String, String> = HashMap()
)