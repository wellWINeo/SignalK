package signalr.kt.abstract

import java.lang.reflect.Type

interface IInvocationBinder {
    fun getReturnType(invocationId: String): Type
    fun getParameterTypes(methodName: String): List<Type>
}
