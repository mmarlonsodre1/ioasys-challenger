package com.example.ioasys.sections.login

import com.example.ioasys.domains.util.RetrofitConection
import com.example.ioasys.models.LoginRequest
import com.example.ioasys.models.LoginResponse
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LoginDataProvider {
    suspend fun postLogin(user: LoginRequest): LoginResponse? {
        return suspendCancellableCoroutine {
            val call = RetrofitConection().apiService.login(user)
            call.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(call: Call<LoginResponse?>?, response: Response<LoginResponse?>) {
                    response.body()?.let { response1 ->
                        response1.headers = response.headers()
                        it.resume(response1)
                    } ?: run {
                        if (response.code() == 401) it.resume(LoginResponse(success = false))
                        else  it.resumeWithException(Throwable())
                    }
                }

                override fun onFailure(call: Call<LoginResponse?>?, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }
}