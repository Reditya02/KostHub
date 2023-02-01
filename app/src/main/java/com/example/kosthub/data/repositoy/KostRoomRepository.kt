package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.BaseResponseMultiData
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.data.remote.model.kostroom.request.AddRatingRequest
import com.example.kosthub.data.remote.model.kostroom.request.AddRoomRequest
import com.example.kosthub.data.remote.model.kostroom.request.SearchRoomRequest
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
        data = DetailRoomResponse(),
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

    fun getRoomById(id: String): MutableLiveData<BaseResponse<DetailRoomResponse>> {
        val apiResponse = MutableLiveData(noRoomByIdResponse)
        val apiRequest = apiService.getRoomById(id)

        apiRequest.enqueue(object : Callback<BaseResponse<DetailRoomResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<DetailRoomResponse>>,
                response: Response<BaseResponse<DetailRoomResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<BaseResponse<DetailRoomResponse>>, t: Throwable) {
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

    fun addRoom(data: AddRoomRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.addRoom(pref.getToken(), data)

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

    fun getAllKost(): MutableLiveData<BaseResponseMultiData<AllKostResponse>> {
        val apiResponse = MutableLiveData(BaseResponseMultiData(
            data = emptyList<AllKostResponse>(),
            message = "no response",
            status = "error"
        ))

        val apiRequest = apiService.getAllKost(pref.getToken())

        apiRequest.enqueue(object : Callback<BaseResponseMultiData<AllKostResponse>> {
            override fun onResponse(
                call: Call<BaseResponseMultiData<AllKostResponse>>,
                response: Response<BaseResponseMultiData<AllKostResponse>>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(
                call: Call<BaseResponseMultiData<AllKostResponse>>,
                t: Throwable
            ) {
                apiResponse.value = BaseResponseMultiData(data = null, message = t.toString(), status = "error")
            }
        })

        return apiResponse
    }

    fun addRating(data: AddRatingRequest): MutableLiveData<BaseResponse<Unit>> {
        val apiResponse = MutableLiveData(noUnitResponse)
        val apiRequest = apiService.addRating(pref.getToken(), data)

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