package com.example.ioasys.sections.home.fragments.list

import com.example.ioasys.domains.util.RetrofitConection
import com.example.ioasys.models.HomeListResponse
import com.example.ioasys.models.LoginResponse
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ListDataProvider {
    suspend fun getList(
            enterprise: String,
            client: String,
            token: String,
            uid: String
    ): HomeListResponse? {
        return suspendCancellableCoroutine {
            val call = RetrofitConection().apiService.list(
                    name = enterprise,
                    client = client,
                    token = token,
                    uid = uid
            )
            call.enqueue(object : Callback<HomeListResponse?> {
                override fun onResponse(call: Call<HomeListResponse?>?, response: Response<HomeListResponse?>) {
                    it.resume(response.body())
                }

                override fun onFailure(call: Call<HomeListResponse?>?, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }
}