package signalr.kt.impls

import com.badoo.reaktive.subject.Subject
import com.badoo.reaktive.subject.replay.ReplaySubject
import kotlin.reflect.KType

class InvocationRequest(
    val type: KType,
    val invocationId: String
) {
    private val pendingCall: Subject<Any> = ReplaySubject()

    fun complete(complete: CompletionMessage) {
        if (complete.Error == null) {
            if (complete.Result != null) {
                this.pendingCall.onNext(complete.Result)
            }
            this.pendingCall.onComplete()
        } else {
            this.pendingCall.onError(HubException(complete.Error))
        }
    }

    fun addId(streamItem: StreamItem) {
        if (streamItem.Item != null) {
            this.pendingCall.onNext(streamItem.Item)
        }
    }

    fun faile(ex: Exception) {
        this.pendingCall.onError(ex)
    }


}