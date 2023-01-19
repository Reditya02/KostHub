package com.example.kosthub.data.repositoy

import com.example.kosthub.application.KostHubApp
import com.example.kosthub.data.remote.model.request.LoginRequest
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject


//@HiltAndroidTest
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = KostHubApp::class)
class AuthRepositoryTest {

    @get:Rule val hiltRule = HiltAndroidRule(this)

    @Inject lateinit var repository: AuthRepository

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun checkLoginSuccess() {
        val data = LoginRequest(password = "Pencari123", email = "redityapencari@mail.com")
        val result = repository.login(data)
        assertEquals("OK", result.status)
    }

    @Test
    fun testing() {
        val result = repository.test()
        assertEquals(1, result)
    }
}