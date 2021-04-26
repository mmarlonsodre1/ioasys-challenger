package com.example.ioasys.domains.util

import com.example.ioasys.models.LoginRequest
import com.example.ioasys.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/auth/sign_in")
    fun login(@Body user: LoginRequest): Call<LoginResponse>


}