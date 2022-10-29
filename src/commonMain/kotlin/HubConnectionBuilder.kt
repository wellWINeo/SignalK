package signalr.kt

abstract class HubConnectionBuilder {
    companion object {
        fun create(url: String): HttpHubConnectionBuilder {
            if (url.isEmpty())
                throw IllegalArgumentException("A valid url is required")
            return HttpHubConnectionBuilder(url)
        }
    }

    abstract fun build(): HubConnection
}