package com.example.kosthub.ui.pemilik.tambahkost

import androidx.lifecycle.ViewModel
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.data.repositoy.KostRoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PemilikTambahKostViewModel @Inject constructor(
    private val repo: KostRoomRepository
) : ViewModel() {
    fun addKost(addKostRequest: AddKostRequest) =
        repo.addNewKost(addKostRequest)
}