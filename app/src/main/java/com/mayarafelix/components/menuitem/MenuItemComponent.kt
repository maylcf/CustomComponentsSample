package com.mayarafelix.components.menuitem

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.mayarafelix.components.R
import com.mayarafelix.components.databinding.ComponentMenuItemBinding
import com.mayarafelix.components.framework.StringUtils

class MenuItemComponent(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private lateinit var componentMenuItemBinding: ComponentMenuItemBinding
    private lateinit var model: MenuItemBindingModel

    init {
        init()
        initModel(attrs)
    }

    private fun init() {
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val layoutInflater = context.getSystemService(infService) as LayoutInflater
        componentMenuItemBinding = ComponentMenuItemBinding.inflate(layoutInflater, this, true)
        model = MenuItemBindingModel()
    }

    private fun initModel(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MenuItemComponent)

        // Get Info
        val containerColor = typedArray.getColor(R.styleable.MenuItemComponent_containerColor, Color.TRANSPARENT)

        val title = typedArray.getString(R.styleable.MenuItemComponent_title)
        val titleColor = typedArray.getColor(R.styleable.MenuItemComponent_titleColor, ContextCompat.getColor(context, R.color.menuItemComponentIcon))

        val defaultTitleSize: Int = resources.getDimensionPixelSize(R.dimen.component_menu_item_default_font_size)
        val titleSize = typedArray.getDimensionPixelSize(R.styleable.MenuItemComponent_titleSize, defaultTitleSize)

        val iconDrawable = typedArray.getDrawable(R.styleable.MenuItemComponent_iconResourceId)

        val iconColor = typedArray.getInteger(R.styleable.MenuItemComponent_iconTint, R.color.menuItemComponentIcon)

        val divisorColor = typedArray.getInteger(R.styleable.MenuItemComponent_divisorColor, R.color.menuItemComponentIcon)

        // Setup Model
        model.title.content = title ?: StringUtils.empty
        model.title.colorRes = titleColor
        model.title.fontSize = titleSize

        model.icon.drawable = iconDrawable
        model.icon.tint = iconColor

        model.divisorColor = divisorColor

        // Setup Container
        if (containerColor != 0) {
            componentMenuItemBinding.componentMenuContainer.setBackgroundColor(containerColor)
        }

        // Recycle TypeArray
        typedArray.recycle()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        componentMenuItemBinding.model = model
    }

    fun updateSelection(isSelected: Boolean) {
        model.selected = isSelected
    }

    fun isMenuItemSelected(): Boolean {
        return model.selected
    }
}
