package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.user.response.AuthResponse
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.user.response.DetailUserResponse
import com.example.kosthub.data.remote.model.user.request.*
import com.example.kosthub.utils.Role
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
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

    fun getUserFromLocale(): MutableLiveData<DetailUserResponse> {
        return MutableLiveData(pref.getUser())
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

    private fun toRequestBody(text: String): RequestBody {
        return text.toRequestBody("text/plain".toMediaType())
    }

    fun updateProfile(data: UpdateProfileRequest): MutableLiveData<BaseResponse<Unit>> {
        var fullname: RequestBody
        var birthdate: RequestBody
        var gender: RequestBody
        var occupation: RequestBody
        var photo: MultipartBody.Part

        data.let {
            fullname = toRequestBody(it.fullname)
            birthdate = toRequestBody(it.birthdate)
            gender = toRequestBody(it.gender)
            occupation = toRequestBody(it.occupation)
            val photoFile = it.photo.asRequestBody("image/jpeg".toMediaTypeOrNull())
            photo = MultipartBody.Part.createFormData(
                "photo",
                data.photo.name,
                photoFile
            )
        }

        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.updateProfile(
            token = pref.getToken(),
            photo = photo,
            fullname = fullname,
            birthdate = birthdate,
            gender = gender,
            occupation = occupation
        )

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

    fun updateIdentity(data: UpdateIdentityRequest): MutableLiveData<BaseResponse<Unit>> {
        val email = toRequestBody(data.email)
        val phone = toRequestBody(data.phone)
        val type = toRequestBody(data.type)
        val photoFile = data.photo.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val photo = MultipartBody.Part.createFormData(
            "photo",
            data.photo.name,
            photoFile
        )

        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.updateIdentity(
            token = pref.getToken(),
            photo = photo,
            email = email,
            phone = phone,
            type = type
        )

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