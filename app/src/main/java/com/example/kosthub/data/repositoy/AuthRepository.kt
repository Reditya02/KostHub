package com.example.kosthub.data.repositoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.request.*
import com.example.kosthub.data.remote.model.response.AuthResponse
import com.example.kosthub.data.remote.model.response.BaseResponse
import com.example.kosthub.data.remote.model.response.DetailUserResponse
import com.example.kosthub.utils.Role
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val pref: AuthPreferences
) {

    private val noAuthResponse = BaseResponse(
        data = AuthResponse(),
        message = "no response",
        status = "error"
    )

    private val noUnitResponse = BaseResponse(
        data = Unit,
        message = "no response",
        status = "error"
    )

    private val noDetailUserResponse = BaseResponse(
        data = DetailUserResponse(),
        message = "no response",
        status = "error"
    )

    fun test(): Int {
        return 1
    }

    fun login(data: LoginRequest): MutableLiveData<BaseResponse<AuthResponse>> {
        val apiResponse = MutableLiveData(noAuthResponse)
        val apiRequest = apiService.login(data)

        apiRequest.enqueue(object : Callback<BaseResponse<AuthResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<AuthResponse>>,
                response: Response<BaseResponse<AuthResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                    if (it.status == "OK") {
                        val token = it.data?.accessToken
                        if (token != null) {
                            getDetailUser(token)
                        }
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
        val apiResponse = MutableLiveData(noAuthResponse)
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
                        val token = it.data?.accessToken
                        if (token != null) {
                            getDetailUser(token)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<AuthResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun changePassword(data: ChangePasswordRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.changePassword(data)

        apiRequest.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(
                call: Call<BaseResponse<Unit>>,
                response: Response<BaseResponse<Unit>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun requestOTP(data: RequestOTPRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.requestOTP(data)

        apiRequest.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(
                call: Call<BaseResponse<Unit>>,
                response: Response<BaseResponse<Unit>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun verifyOTP(data: VerifyOTPRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.verifyOTP(data)

        apiRequest.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(
                call: Call<BaseResponse<Unit>>,
                response: Response<BaseResponse<Unit>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun getDetailUser(token: String): MutableLiveData<BaseResponse<DetailUserResponse>> {
        val apiResponse = MutableLiveData(noDetailUserResponse)
        val apiRequest = apiService.getDetailUser(token)

        apiRequest.enqueue(object : Callback<BaseResponse<DetailUserResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<DetailUserResponse>>,
                response: Response<BaseResponse<DetailUserResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                    if (it.status == "OK") {
                        it.data?.let { it1 -> pref.setUser(it1) }
                        pref.setToken(token)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<DetailUserResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun updateBankAccount(data: UpdateBankAccountRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.updateBankAccount(pref.getToken(), data)

        apiRequest.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(
                call: Call<BaseResponse<Unit>>,
                response: Response<BaseResponse<Unit>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                    if (it.status == "OK") {
                        getDetailUser(pref.getToken())
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })
        return apiResponse
    }



}