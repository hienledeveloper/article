package appfree.io.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkManager {

    val accessToken: String? = null
    val refreshToken: String? = null

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                // ... add your own JsonAdapters and factories ...
                .add(KotlinJsonAdapterFactory())
                .build()))
        .build()

}