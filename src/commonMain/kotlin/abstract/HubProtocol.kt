package signalr.kt.abstract

abstract class HubProtocol {
    abstract val name: String
    abstract val version: Int

    abstract fun parseMessages(message: ByteArray, binder: IInvocationBinder): List<HubMessage>
    abstract fun writeMessage(message: HubMessage): ByteArray
}