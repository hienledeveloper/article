package appfree.io.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ArticleApiService {

    @GET
    fun auth(@Url url: String): Call<String>

    @GET
    suspend fun getNews(@Url url: String): String

}