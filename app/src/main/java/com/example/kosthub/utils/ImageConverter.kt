package com.example.kosthub.utils

import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.util.*


object ImageConverter {
    fun imageToBase64(image: File): String {
        val bytes = image.readBytes()
        val base64 = Base64.getEncoder().encodeToString(bytes)
        return base64
    }

//    fun base64ToImage(base64: String): File {
//        val byteArray = Base64.getDecoder().decode(base64)
//        val res = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//        return res
//    }
}