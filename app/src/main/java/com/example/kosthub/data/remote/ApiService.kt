package com.example.kosthub.data.remote

import com.example.kosthub.data.remote.model.request.*
import com.example.kosthub.data.remote.model.response.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    //Auth
    @POST("/v1/auth/login")
    fun login(@Body body: LoginRequest): Call<Response>

    @POST("/v1/auth/penyewa/register")
    fun registerPenyewa(@Body body: RegisterRequest): Call<Response>

    @POST("/v1/auth/pencari/register")
    fun registerPencari(@Body body: RegisterRequest): Call<Response>

    @POST("/v1/auth/password")
    fun changePassword(@Body body: ChangePasswordRequest): Call<Response>

    //OTP
    @POST("/v1/verify/request")
    fun requestOTP(@Body body: RequestOTPRequest): Call<Response>

    @POST("/v1/verify")
    fun verifyOTP(@Body body: VerifyOTPRequest): Call<Response>

}