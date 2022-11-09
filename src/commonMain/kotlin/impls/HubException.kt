package signalr.kt.impls

class HubException : RuntimeException {
    constructor(): super()
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
    constructor(message: String, innerException: Exception): super(message, innerException)
}