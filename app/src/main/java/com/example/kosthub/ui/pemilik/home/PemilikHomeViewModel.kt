package com.example.kosthub.ui.pemilik.home

import androidx.lifecycle.ViewModel
import com.example.kosthub.data.repositoy.UserRepository
import com.example.kosthub.data.repositoy.dummy.DummyUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PemilikHomeViewModel @Inject constructor(
    private val userRepo: UserRepository
) : ViewModel() {
    val getStatistic = DummyUserRepository.getStatistics()
}