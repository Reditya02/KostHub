package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.BaseResponseMultiData
import com.example.kosthub.data.remote.model.kostroom.request.BookingRequest
import com.example.kosthub.data.remote.model.kostroom.request.UpdateTransactionRequest
import com.example.kosthub.data.remote.model.kostroom.response.AllTransactionResponse
import com.example.kosthub.data.remote.model.kostroom.response.TransactionOwnerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
}