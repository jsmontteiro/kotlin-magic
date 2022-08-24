package libraries.network.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

internal class BasicLoggerInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().let { builder ->
            builder.addHeader("Content-Type", "application/json")

            builder.build()
        }
        Log.d("HTTP", "url call: ${request.url}")

        val response = chain.proceed(request)

        Log.d("HTTP","url return(${response.code}): ${request.url}")

        return response
    }
}