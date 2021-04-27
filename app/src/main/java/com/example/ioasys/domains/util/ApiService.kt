package com.example.ioasys.domains.util

import com.example.ioasys.models.DetailEnterpriseResponse
import com.example.ioasys.models.HomeListResponse
import com.example.ioasys.models.LoginRequest
import com.example.ioasys.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("users/auth/sign_in")
    fun login(@Body user: LoginRequest): Call<LoginResponse>

    @GET("enterprises")
    fun list(
            @Query("enterprise_types") types: Int = 3,
            @Query("name") name: String,
            @Header("access-token") token: String,
            @Header("client") client: String,
            @Header("uid") uid: String
    ): Call<HomeListResponse>

    @GET("enterprises/{id}")
    fun detail(
            @Path("id") id: Int,
            @Header("access-token") token: String,
            @Header("client") client: String,
            @Header("uid") uid: String
    ): Call<DetailEnterpriseResponse>
}