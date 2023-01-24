package com.example.kosthub.data.remote

import com.example.kosthub.data.remote.model.request.*
import com.example.kosthub.data.remote.model.response.AuthResponse
import com.example.kosthub.data.remote.model.response.BaseResponse
import com.example.kosthub.data.remote.model.response.DetailUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    //Auth
    @POST("/v1/auth/login")
    fun login(
        @Body body: LoginRequest
    ): Call<BaseResponse<AuthResponse>>

    @POST("/v1/auth/penyewa/register")
    fun registerPenyewa(
        @Body body: RegisterRequest
    ): Call<BaseResponse<AuthResponse>>

    @POST("/v1/auth/pencari/register")
    fun registerPencari(
        @Body body: RegisterRequest
    ): Call<BaseResponse<AuthResponse>>

    @POST("/v1/auth/password")
    fun changePassword(
        @Body body: ChangePasswordRequest
    ): Call<BaseResponse<Unit>>

    //OTP
    @POST("/v1/verify/request")
    fun requestOTP(
        @Body body: RequestOTPRequest
    ): Call<BaseResponse<Unit>>

    @POST("/v1/verify")
    fun verifyOTP(
        @Body body: VerifyOTPRequest
    ): Call<BaseResponse<Unit>>

    //Account
    @GET("/v1/account/profile")
    fun getDetailUser(
        @Header("Authorization") token: String
    ): Call<BaseResponse<DetailUserResponse>>

}