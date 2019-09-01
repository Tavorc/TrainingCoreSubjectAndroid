package com.example.tavorcohen.recycleviewexample.utils

import android.graphics.Bitmap
import java.net.URL
import android.graphics.BitmapFactory
import android.R.attr.src
import android.content.Context
import android.util.DisplayMetrics
import java.io.IOException


class LayoutUtils {

    companion object {
        /**
         *  change the direction of the arrow image when the language of the device is from left to right
         */
        fun convertUrlToBitmap(url : URL) : Bitmap{

                return BitmapFactory.decodeStream(url.openConnection().getInputStream())
        }

        fun convertDpToPixel(context: Context, dp: Int): Int {
            val metrics = context.resources.displayMetrics
            return dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
        }

    }
}