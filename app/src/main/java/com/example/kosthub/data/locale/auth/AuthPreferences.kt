package com.example.kosthub.data.locale.auth

import android.content.Context
import com.example.kosthub.data.model.user.UserProfile
import com.example.kosthub.data.remote.model.user.response.AuthResponse
import com.example.kosthub.data.remote.model.user.response.DetailUserResponse
import com.google.gson.Gson

class AuthPreferences(context: Context) {
    private val pref = "pref"
    private val userKey = "user"
    private val tokenKey = "token"

    private var preferences = context.getSharedPreferences(pref, Context.MODE_PRIVATE)

    fun getToken(): String {
        return preferences.getString(tokenKey, "-1") ?: "-1"
    }

    fun setToken(token: String) {
        preferences.edit().apply {
            putString(tokenKey, token)
            apply()
        }
    }

    fun getUser(): DetailUserResponse {
        val user = preferences.getString(userKey, null)
        return Gson().fromJson(user, DetailUserResponse::class.java)
    }

    fun setUser(user: DetailUserResponse) {
        val json = Gson().toJson(user)
        preferences.edit().putString(userKey, json).apply()
    }


}