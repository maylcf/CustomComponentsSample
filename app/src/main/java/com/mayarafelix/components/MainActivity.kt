package com.mayarafelix.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.mayarafelix.components.menuitem.MenuItemComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuItem = findViewById<MenuItemComponent>(R.id.menuitem1);
        val button = findViewById<Button>(R.id.button);
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                menuItem.updateSelection(!menuItem.isMenuItemSelected())
            }
        })

        val menuItem2 = findViewById<MenuItemComponent>(R.id.menuitem2);
        val button2 = findViewById<Button>(R.id.button2);
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                menuItem2.updateSelection(!menuItem2.isMenuItemSelected())
            }
        })
    }
}
