package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.data.remote.model.kostroom.request.SearchRoomRequest
import com.example.kosthub.data.remote.model.kostroom.response.GetRoomByIdResponse
import com.example.kosthub.data.remote.model.kostroom.response.OwnerKostResponse
import com.example.kosthub.data.remote.model.kostroom.response.SearchRoomResponse
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


    private val noSearchRoomResponse = SearchRoomResponse()

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

    fun searchRoom(data: SearchRoomRequest): MutableLiveData<SearchRoomResponse> {
        val apiResponse = MutableLiveData(noSearchRoomResponse)
        var apiRequest: Call<SearchRoomResponse>

        data.apply {
            apiRequest = apiService.searchRoom(
                keyword, label, type, priceMin, priceMax, size
            )
        }

        apiRequest.enqueue(object : Callback<SearchRoomResponse> {
            override fun onResponse(
                call: Call<SearchRoomResponse>,
                response: Response<SearchRoomResponse>
            ) {
                response.body()?.let {
                    apiResponse.value = it
                }
            }

            override fun onFailure(call: Call<SearchRoomResponse>, t: Throwable) {
                apiResponse.value = SearchRoomResponse(data = null, message = t.toString(), status = "error")
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
}