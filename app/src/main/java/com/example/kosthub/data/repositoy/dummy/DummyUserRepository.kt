package com.example.kosthub.data.repositoy.dummy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.user.response.StatisticResponse

class DummyUserRepository {
    fun getStatistics(): MutableLiveData<BaseResponse<StatisticResponse>> {
        val dummyResponse = MutableLiveData(BaseResponse<StatisticResponse>(
            data = StatisticResponse(
                bookers = 3,
                emptyRooms = 5,
                id = null,
                occupants = 20
            ),
            message = "",
            status = "",
            error = null
        ))

        return dummyResponse
    }
}