package libraries.network

import libraries.network.exceptions.MyNetworkException
import libraries.network.exceptions.ServerErrorException
import retrofit2.Response

object RequestManager {
    suspend fun <T> requestFromApi(
        request: (suspend () -> Response<T>)
    ): T? {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body()
            } else {
                val message = response.message()

                throw when (response.code()) {
                    500 -> ServerErrorException(message)
                    else -> MyNetworkException(message)
                }
            }

        } catch (e: Exception) {
            throw e
        }
    }
}