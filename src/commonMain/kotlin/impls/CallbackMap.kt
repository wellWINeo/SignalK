package signalr.kt.impls

import java.lang.reflect.Type
import java.util.concurrent.ConcurrentHashMap

internal class CallbackMap {
    private val handlers: ConcurrentHashMap<String, List<InvocationHandler>> = ConcurrentHashMap()

    fun put(target: String, action: Any, vararg types: Type): InvocationHandler {
        val handler = InvocationHandler(action, *types)
        if (this.handlers.contains(target)) {
            this.handlers[target] = ArrayList()
        }

        val methodHandlers = this.handlers[target]?.toMutableList() ?: mutableListOf()
        if (handler.getHasResult() && methodHandlers.any { it.getHasResult() })
            throw RuntimeException("'$target' already has a value returning handler. Multiple return values are not supported.")

        methodHandlers.add(handler)

        this.handlers[target] = methodHandlers

        return handler
    }

    fun get(key: String): List<InvocationHandler> {
        return this.handlers[key] ?: emptyList()
    }

    fun remove(key: String) {
        this.handlers.remove(key)
    }

    fun remove(key: String, handler: InvocationHandler) {
        val handlers = this.handlers[key]
        if (handlers != null) {
            handlers.filter { it == handler }

            this.handlers[key] = handlers
        }
    }
}