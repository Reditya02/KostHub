package com.example.kosthub.data.repositoy

import android.view.SurfaceControl.Transaction
import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.BaseResponseMultiData
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.data.remote.model.kostroom.request.SearchRoomRequest
import com.example.kosthub.data.remote.model.kostroom.request.UpdateTransactionRequest
import com.example.kosthub.data.remote.model.kostroom.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class KostRoomRepository @Inject constructor(
    private val apiService: ApiService,
    private val pref: AuthPreferences
) {
    private val noUnitResponse = BaseResponse(
        data = Unit,
        message = "no response",
        status = "error"
    )

    private val noRoomByIdResponse = BaseResponse(
        data = GetRoomByIdResponse(),
        message = "no response",
        status = "error"
    )

    private val noOwnerByIdResponse = BaseResponse(
        data = OwnerKostResponse(),
        message = "no response",
        status = "error"
    )

    private val noSearchRoomResponse = BaseResponseMultiData(
        data = emptyList<SearchRoomResponse>(),
        message = "no response",
        status = "error"
    )

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

    fun addNewKost(data: AddKostRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.addNewKost(pref.getToken(), data)

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

    fun updateKost(data: AddKostRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.updateKost(pref.getToken(), data)

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

    fun searchRoom(data: SearchRoomRequest): MutableLiveData<BaseResponseMultiData<SearchRoomResponse>> {
        val apiResponse = MutableLiveData(noSearchRoomResponse)
        var apiRequest: Call<BaseResponseMultiData<SearchRoomResponse>>

        data.apply {
            apiRequest = apiService.searchRoom(
                keyword, label, type, priceMin, priceMax, size
            )
        }

        apiRequest.enqueue(object : Callback<BaseResponseMultiData<SearchRoomResponse>> {
            override fun onResponse(
                call: Call<BaseResponseMultiData<SearchRoomResponse>>,
                response: Response<BaseResponseMultiData<SearchRoomResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponseMultiData<SearchRoomResponse>>, t: Throwable) {
                apiResponse.value = BaseResponseMultiData(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun getRoomById(id: String): MutableLiveData<BaseResponse<GetRoomByIdResponse>> {
        val apiResponse = MutableLiveData(noRoomByIdResponse)
        val apiRequest = apiService.getRoomById(id)

        apiRequest.enqueue(object : Callback<BaseResponse<GetRoomByIdResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<GetRoomByIdResponse>>,
                response: Response<BaseResponse<GetRoomByIdResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<GetRoomByIdResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun getOwnerKostById(id: String): MutableLiveData<BaseResponse<OwnerKostResponse>> {
        val apiResponse = MutableLiveData(noOwnerByIdResponse)
        val apiRequest = apiService.getOwnerKostById(id)

        apiRequest.enqueue(object : Callback<BaseResponse<OwnerKostResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<OwnerKostResponse>>,
                response: Response<BaseResponse<OwnerKostResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<OwnerKostResponse>>, t: Throwable) {
                apiResponse.value = BaseResponse(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

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
}