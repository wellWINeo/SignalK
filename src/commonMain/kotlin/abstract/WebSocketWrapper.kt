package signalr.kt.abstract

import io.reactivex.rxjava3.core.Completable
import signalr.abstract.IOnCloseCallback
import signalr.abstract.IOnReceiveCallback

abstract class WebSocketWrapper {
    public abstract fun start(): Completable
    public abstract fun stop(): Completable
    public abstract fun send(message: Array<Byte>): Completable

    public abstract var onReceive: IOnReceiveCallback
    public abstract var onClose: IOnCloseCallback
}
