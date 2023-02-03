package com.example.kosthub.data.repositoy.dummy

import androidx.lifecycle.MutableLiveData
import com.example.kosthub.data.remote.model.BaseResponse
import com.example.kosthub.data.remote.model.user.response.StatisticResponse

object DummyUserRepository {
    fun getStatistics(): MutableLiveData<BaseResponse<StatisticResponse>> {
        val dummyResponse = MutableLiveData(BaseResponse(
            data = StatisticResponse(
                bookers = 3,
                emptyRooms = 5,
                id = 2,
                occupants = 20
            ),
            message = "",
            status = "200",
            error = null
        ))

        return dummyResponse
    }
}