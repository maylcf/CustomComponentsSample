package com.mayarafelix.components.framework

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes

class ImageModel {

    var drawable: Drawable? = null

    var description: String = StringUtils.empty

    @ColorRes
    var tint: Int? = null
}