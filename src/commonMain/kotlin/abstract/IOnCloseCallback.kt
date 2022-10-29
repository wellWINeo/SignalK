package signalr.abstract

public interface IOnCloseCallback {
    fun invoke(exception: Exception): Void
}
