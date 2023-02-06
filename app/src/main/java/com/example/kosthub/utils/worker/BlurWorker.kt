package com.example.kosthub.utils.worker

import android.content.Context
import android.graphics.BitmapFactory
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class BlurWorker(ctx: Context, param: WorkerParameters) : Worker(ctx, param) {

    override fun doWork(): Result {
        val image = inputData.getString("image")

        return try {
            val bitmap = BitmapFactory.decodeFile(image)

            val compressed = blurBitmap(bitmap, applicationContext)

            val output = writeBitmapToFile(applicationContext, compressed)

            val result = workDataOf("result" to output)

            Result.success(result)
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }


}