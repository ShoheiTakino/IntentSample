package com.websarva.wings.android.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MenuThanksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)
        setupInitView()

    }

    private fun setupInitView() {
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("meniPrice")
        val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice
    }

    fun onBackButtonClick(view: View) {
        finish()
    }
}