package com.example.kosthub.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KostHubApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: KostHubApp
            private set
    }
}