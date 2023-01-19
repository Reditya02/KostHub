package com.example.kosthub.application

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

@HiltAndroidTest
class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        classLoader: ClassLoader?,
        name: String?,
        context: Context?
    ): Application {
        return super.newApplication(
            classLoader,
            KostHubApp::class.java.name,
            context
        )
    }
}