package com.example.kosthub.data.remote

import com.example.kosthub.data.remote.model.request.*
import com.example.kosthub.data.remote.model.response.AuthResponse
import com.example.kosthub.data.remote.model.response.BaseResponse
import com.example.kosthub.data.remote.model.response.DetailUserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

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

    @Multipart
    @POST("/v1/account/profile")
    fun updateProfile(
        @Header("Authorization") token: String,
        @Part photo: MultipartBody.Part,
        @Part("fullname") fullname: RequestBody,
        @Part("birthdate") birthdate: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("occupation") occupation: RequestBody
    ): Call<BaseResponse<Unit>>

    @POST("/v1/account/bank")
    fun updateBankAccount(
        @Header("Authorization") token: String,
        @Body body: UpdateBankAccountRequest
    ): Call<BaseResponse<Unit>>

}