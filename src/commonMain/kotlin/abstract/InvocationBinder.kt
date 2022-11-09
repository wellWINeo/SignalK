package signalr.kt.abstract

import kotlin.reflect.KType

interface IInvocationBinder {
    fun getReturnType(invocationId: String): KType
    fun getParameterTypes(methodName: String): List<KType>
}
