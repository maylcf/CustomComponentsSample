package com.mayarafelix.components.framework

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes

class TextModel {

    var content: String = StringUtils.empty

    @DimenRes
    var fontSize: Int? = null

    @ColorRes
    var colorRes: Int? = null
}