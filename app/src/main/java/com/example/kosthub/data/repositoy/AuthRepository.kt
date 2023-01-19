package com.example.kosthub.data.repositoy

import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.request.LoginRequest
import com.example.kosthub.data.remote.model.response.AuthResponse
import com.example.kosthub.data.remote.model.response.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val pref: AuthPreferences
) {

    private val noResponse = BaseResponse(data = null, message = "no response", status = "error")

    fun test(): Int {
        return 1
    }

    fun login(data: LoginRequest): BaseResponse {
        var apiResponse: BaseResponse = noResponse
        val apiRequest = apiService.login(data)
        apiRequest.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                response.body()?.let {
                    apiResponse = it
                    if (it.status == "OK") {
                        pref.setUser(it.data as AuthResponse)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                apiResponse = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })
        return apiResponse
    }
}