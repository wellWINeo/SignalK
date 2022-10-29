package signalr.kt.abstract

import io.reactivex.rxjava3.core.Single

interface IFunction {
    fun invoke(vararg params: Any): Single<Any>
}