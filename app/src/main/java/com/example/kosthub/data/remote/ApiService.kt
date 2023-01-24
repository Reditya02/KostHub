package com.example.kosthub.data.remote

import android.util.Size
import com.example.kosthub.data.remote.model.user.response.AuthResponse
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.data.remote.model.kostroom.response.GetRoomByIdResponse
import com.example.kosthub.data.remote.model.kostroom.response.OwnerKostResponse
import com.example.kosthub.data.remote.model.kostroom.response.SearchRoomResponse
import com.example.kosthub.data.remote.model.user.response.DetailUserResponse
import com.example.kosthub.data.remote.model.user.request.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

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

    @Multipart
    @POST("/v1/account/verification")
    fun updateIdentity(
        @Header("Authorization") token: String,
        @Part photo: MultipartBody.Part,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("type") type: RequestBody
    ): Call<BaseResponse<Unit>>

    @POST("/v1/account/bank")
    fun updateBankAccount(
        @Header("Authorization") token: String,
        @Body body: UpdateBankAccountRequest
    ): Call<BaseResponse<Unit>>

    //Kost
    @POST("/v1/kost/add")
    fun addNewKost(
        @Header("Authorization") token: String,
        @Body body: AddKostRequest
    ): Call<BaseResponse<Unit>>

    @POST("/v1/kost/update")
    fun updateKost(
        @Header("Authorization") token: String,
        @Body body: AddKostRequest
    ): Call<BaseResponse<Unit>>

    //Room
    @GET("/v1/search")
    fun searchRoom(
        @Query("keyword") keyword: String? = null,
        @Query("label") label: String? = null,
        @Query("type") type: String? = null,
        @Query("price_min") priceMin: Long? = null,
        @Query("price_max") priceMax: Long? = null,
        @Query("size") size: Int? = null
    ): Call<SearchRoomResponse>

    @GET("/v1/rooms/{roomId}")
    fun getRoomById(
        @Path("roomId") id: String,
    ): Call<BaseResponse<GetRoomByIdResponse>>

    @GET("/v1/rooms/contact/{roomId}")
    fun getOwnerKostById(
        @Path("roomId") id: String
    ): Call<BaseResponse<OwnerKostResponse>>


}