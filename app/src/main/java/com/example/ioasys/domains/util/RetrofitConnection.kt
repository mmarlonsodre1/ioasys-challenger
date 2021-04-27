package com.example.ioasys.domains.util

import com.example.ioasys.MyApplication
import com.google.gson.GsonBuilder
import okhttp3.CertificatePinner
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConection {
    var apiService: ApiService

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val loggingInterceptor = HttpLoggingInterceptor().apply { level =
            HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS))
            .certificatePinner(
                CertificatePinner.Builder()
                    .add("oasys.com.br", "sha256/mh10HkeFKAzIAy6n5n4s+aBYabXh2Eruj2jUGEHu8fc=")
                    .build())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("${MyApplication().BASE_URL}/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }
}
