package signalr.kt.abstract

interface IAction {
    fun invoke(vararg params: Any)
}