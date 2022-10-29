package signalr.kt.impls

import signalr.kt.abstract.IFunction
import java.lang.reflect.Type

internal class InvocationHandler(val action: Any, vararg types: Type) {
    val Types: List<Type>

    init {
        this.Types = types.asList()
    }

    fun getHasResult(): Boolean {
        return this.action is IFunction
    }
}