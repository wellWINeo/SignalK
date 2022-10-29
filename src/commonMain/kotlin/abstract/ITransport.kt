package signalr.kt.enum

import io.reactivex.rxjava3.core.Completable
import signalr.abstract.IOnCloseCallback
import signalr.abstract.IOnReceiveCallback

public interface ITransport {
    fun Start(url: String): Completable
    fun Send(message: ByteArray): Completable
    fun Stop(): Completable

    var OnReceive: IOnReceiveCallback
    var OnClose: IOnCloseCallback
}
