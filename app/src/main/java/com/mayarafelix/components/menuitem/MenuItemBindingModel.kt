package com.mayarafelix.components.menuitem

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.mayarafelix.components.framework.ImageModel
import com.mayarafelix.components.framework.TextModel

class MenuItemBindingModel : BaseObservable() {

    @Bindable
    var selected: Boolean = false
        set(value) {
            field = value

            if (value) {
                divisorVisibility = View.VISIBLE
            } else {
                divisorVisibility = View.INVISIBLE
            }

            notifyPropertyChanged(BR.selected)
        }

    @Bindable
    var divisorVisibility: Int = View.INVISIBLE
        set(value) {
            field = value
            notifyPropertyChanged(BR.divisorVisibility)
        }

    @Bindable
    var divisorColor: Int = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.divisorColor)
        }

    @Bindable
    var title: TextModel = TextModel()
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var icon: ImageModel = ImageModel()
        set(value) {
            field = value
            notifyPropertyChanged(BR.icon)
        }

    val getTitleVisibility: Int
        get() {
            if (title.content.isNotEmpty()) {
                return View.VISIBLE
            } else {
                return View.GONE
            }
        }

    val getIconVisibility: Int
        get() {
            if (icon.drawable != null) {
                return View.VISIBLE
            } else {
                return View.GONE
            }
        }
}
