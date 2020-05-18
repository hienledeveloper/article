package appfree.io.core.data.event

sealed class NetworkEvent<out T> {

    data class SUCCESS<T>(val data: T) : NetworkEvent<T>()
    data class ERROR(val error: Throwable) : NetworkEvent<Nothing>()

}

data class ErrorNetwork(
    var code: Int? = null,
    var errorString: String? = null,
    val type: ErrorNetworkType
)

enum class ErrorNetworkType {
    HTTP_OFFLINE,
    HTTP_TIME_OUT,
    HTTP_SERVER_ERROR,
    HTTP_ERROR
}