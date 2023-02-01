package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.BaseResponseMultiData
import com.example.kosthub.data.remote.model.kostroom.request.BookingRequest
import com.example.kosthub.data.remote.model.transaction.request.UpdateTransactionRequest
import com.example.kosthub.data.remote.model.transaction.response.AllTransactionResponse
import com.example.kosthub.data.remote.model.transaction.response.TransactionByIdResponse
import com.example.kosthub.data.remote.model.transaction.response.TransactionOwnerResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val apiService: ApiService,
    private val pref: AuthPreferences
) {

    private val noTransactionResponse = BaseResponseMultiData(
        data = emptyList<AllTransactionResponse>(),
        message = "no response",
        status = "error"
    )

    private val noTransactionOwnerResponse = BaseResponseMultiData(
        data = emptyList<TransactionOwnerResponse>(),
        message = "no response",
        status = "error"
    )

    private val noUnitResponse = BaseResponse(
        data = Unit,
        message = "no response",
        status = "error"
    )

    private val noTransactionByIdResponse = BaseResponseMultiData(
        data = emptyList<TransactionByIdResponse>(),
        message = "no response",
        status = "error"
    )

    fun getAllTransaction(): MutableLiveData<BaseResponseMultiData<AllTransactionResponse>> {
        val apiResponse = MutableLiveData(noTransactionResponse)
        val apiRequest = apiService.getAlltransaction(pref.getToken())

        apiRequest.enqueue(object : Callback<BaseResponseMultiData<AllTransactionResponse>> {
            override fun onResponse(
                call: Call<BaseResponseMultiData<AllTransactionResponse>>,
                response: Response<BaseResponseMultiData<AllTransactionResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(
                call: Call<BaseResponseMultiData<AllTransactionResponse>>,
                t: Throwable
            ) {
                apiResponse.value = BaseResponseMultiData(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun getTransactionOwner(): MutableLiveData<BaseResponseMultiData<TransactionOwnerResponse>> {
        val apiResponse = MutableLiveData(noTransactionOwnerResponse)
        val apiRequest = apiService.getTransactionOwner(pref.getToken())

        apiRequest.enqueue(object : Callback<BaseResponseMultiData<TransactionOwnerResponse>> {
            override fun onResponse(
                call: Call<BaseResponseMultiData<TransactionOwnerResponse>>,
                response: Response<BaseResponseMultiData<TransactionOwnerResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(
                call: Call<BaseResponseMultiData<TransactionOwnerResponse>>,
                t: Throwable
            ) {
                apiResponse.value = BaseResponseMultiData(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun updateTransaction(id: String, data: UpdateTransactionRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.updateTransaction(pref.getToken(), id, data)

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

    fun bookingRoom(data: BookingRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.bookingRoom(pref.getToken(), data)

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

    fun uploadPaymentProof(image: File, id: Int): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)

        val idData = id.toString().toRequestBody("text/plain".toMediaType())
        val imageFile = image.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageData = MultipartBody.Part.createFormData(
            "image",
            image.name,
            imageFile
        )

        val apiRequest = apiService.uploadPaymentProof(pref.getToken(), imageData, idData)

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

    fun getTransactionById(id: String): MutableLiveData<BaseResponseMultiData<TransactionByIdResponse>> {
        val apiResponse = MutableLiveData(noTransactionByIdResponse)
        val apiRequest = apiService.getTransactionById(pref.getToken(), id)

        apiRequest.enqueue(object : Callback<BaseResponseMultiData<TransactionByIdResponse>> {
            override fun onResponse(
                call: Call<BaseResponseMultiData<TransactionByIdResponse>>,
                response: Response<BaseResponseMultiData<TransactionByIdResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(
                call: Call<BaseResponseMultiData<TransactionByIdResponse>>,
                t: Throwable
            ) {
                apiResponse.value = BaseResponseMultiData(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }
}