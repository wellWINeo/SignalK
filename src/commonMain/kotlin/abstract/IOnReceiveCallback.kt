package signalr.abstract

interface IOnReceiveCallback {
    fun invoke(message: Iterable<Byte>): Void
}
