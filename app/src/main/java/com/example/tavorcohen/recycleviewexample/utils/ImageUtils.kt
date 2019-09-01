package com.wefixapp.wefixisr.v2.view.utils

import android.content.res.Resources
import android.view.View
import android.widget.ImageView


class ImageUtils {

    companion object {
        /**
         *  change the direction of the arrow image when the language of the device is from left to right
         */
         fun configureForLeftToRight(resources : Resources,image  : ImageView,scaleX: Float){
            val config = resources.configuration
            if(config.layoutDirection == View.LAYOUT_DIRECTION_LTR) {
                //change the direction of the arrow when the language of the device is from left to right
                image.scaleX = scaleX
            }
        }

    }
}