package com.example.kosthub.ui.main.register

import androidx.lifecycle.ViewModel
import com.example.kosthub.data.remote.model.user.request.RegisterRequest
import com.example.kosthub.data.repositoy.UserRepository
import com.example.kosthub.utils.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepo: UserRepository
) : ViewModel() {
    fun register(data: RegisterRequest, role: Role) = userRepo.register(data, role)
}