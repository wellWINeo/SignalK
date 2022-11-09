package signalr.kt.impls

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import signalr.kt.abstract.IInvocationBinder
import kotlin.reflect.KType

internal class ConnectionState : IInvocationBinder  {
    // Originally here uses AtomicInteger, but i couldn't find
    // a way to use atomic values in Kotlin Multiplatform
    private val nextId: Int = 0
    private val mutex = Mutex()
    private val pendingInvocation: MutableMap<String, InvocationRequest> = mutableMapOf<>()

    override fun getReturnType(invocationId: String): KType {
        TODO("Not yet implemented")
    }

    override fun getParameterTypes(methodName: String): List<KType> {
        TODO("Not yet implemented")
    }
I
    fun getNextInvocationId(): String {
        nextId.inc()
        return nextId.toString()
    }

    suspend fun cancelOutStandingInvocations(ex: Exception) {
        this.mutex.withLock {
             val keys =
        }
    }
}