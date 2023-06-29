package com.rave.mathbooks.model.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val mediaType = MediaType.get("application/json")

    @OptIn(ExperimentalSerializationApi::class)
    private fun providesJson(): Json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://openlibrary.org/")
            .addConverterFactory(providesJson().asConverterFactory(mediaType))
            .build()
    }

    @Provides
    fun providesAPIService(retrofit: Retrofit): APIService = retrofit.create()
}
