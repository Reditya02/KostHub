package com.example.kosthub.data.repositoy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.request.LoginRequest
import com.example.kosthub.data.remote.model.request.RegisterRequest
import com.example.kosthub.data.remote.model.response.AuthResponse
import com.example.kosthub.data.remote.model.response.BaseResponse
import com.example.kosthub.utils.Role
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val pref: AuthPreferences
) {

    private val noResponse = BaseResponse(
        data = AuthResponse(),
        message = "no response",
        status = "error"
    )

    fun test(): Int {
        return 1
    }

    fun login(data: LoginRequest): MutableLiveData<BaseResponse<AuthResponse>> {
        val apiResponse = MutableLiveData(noResponse)
        val apiRequest = apiService.login(data)

        apiRequest.enqueue(object : Callback<BaseResponse<AuthResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<AuthResponse>>,
                response: Response<BaseResponse<AuthResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                    if (it.status == "OK") {
                        pref.setUser(it.data as AuthResponse)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<AuthResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })
        return apiResponse
    }

    fun register(data: RegisterRequest, role: Role): MutableLiveData<BaseResponse<AuthResponse>> {
        val apiResponse = MutableLiveData(noResponse)
        val apiRequest =
            if (role == Role.pencari)
                apiService.registerPencari(data)
            else
                apiService.registerPenyewa(data)

        apiRequest.enqueue(object : Callback<BaseResponse<AuthResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<AuthResponse>>,
                response: Response<BaseResponse<AuthResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                    if (it.status == "OK") {
                        pref.setUser(it.data as AuthResponse)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<AuthResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }
}