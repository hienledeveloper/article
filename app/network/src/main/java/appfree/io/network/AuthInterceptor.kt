package appfree.io.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    private val AUTHORIZATION = "Authorization"
    private val HTTP_CODE_EXPIRED_ACCESS_TOKEN = 401
    private val HTTP_CODE_ERROR_RESPONSE = 400
    private val ACCESS_TOKEN = "access_token"

    override fun intercept(chain: Interceptor.Chain): Response? {
        val original = chain.request()
        val builder = original.newBuilder().method(original.method(), original.body())
        if (!NetworkManager.accessToken.isNullOrEmpty()) {
            builder.addHeader(AUTHORIZATION, "Bearer ".plus(NetworkManager.accessToken))
        }

        val response = chain.proceed(builder.build())

        if (response.code()==HTTP_CODE_ERROR_RESPONSE) { }
        if (response.code()==HTTP_CODE_EXPIRED_ACCESS_TOKEN || hasExpiredAccessToken(response)) {
            val apiService = NetworkManager.retrofit.create(ArticleApiService::class.java)

            apiService.auth("").execute().body().let { accessToken ->
                builder.removeHeader(AUTHORIZATION)
                builder.addHeader(AUTHORIZATION, "Bearer ".plus(accessToken))
                return chain.proceed(builder.build())
            }
        }

        return response
    }

    private fun hasExpiredAccessToken(response: Response): Boolean {
        val responseBody = response.peekBody(Long.MAX_VALUE)
        val content = responseBody.string()
        if (content.contains(ACCESS_TOKEN) && content.contains(HTTP_CODE_EXPIRED_ACCESS_TOKEN.toString())) {
            return true
        }
        return false
    }

}