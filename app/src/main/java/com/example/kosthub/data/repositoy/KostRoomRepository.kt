package com.example.kosthub.data.repositoy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
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
}