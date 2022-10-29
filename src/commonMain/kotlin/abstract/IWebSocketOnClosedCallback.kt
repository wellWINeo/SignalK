package signalr.kt.abstract

interface IWebSocketOnClosedCallback {
    fun invoke(code: Int, reason: String)
}
