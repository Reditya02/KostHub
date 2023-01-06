package com.example.kosthub.ui.main.welcome

import androidx.lifecycle.ViewModel
import com.example.kosthub.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun print() = repository.test()
}