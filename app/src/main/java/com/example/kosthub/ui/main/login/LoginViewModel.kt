package com.example.kosthub.ui.main.login

import androidx.lifecycle.ViewModel
import com.example.kosthub.data.remote.model.user.request.LoginRequest
import com.example.kosthub.data.repositoy.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepo: UserRepository
) : ViewModel() {
    fun login(data: LoginRequest) = userRepo.login(data)
}