package com.websarva.wings.android.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListViewAdapter()
    }

    private fun setupListViewAdapter() {
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "雑魚定食", "price" to "80円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "CoCo壱定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "吉野家定食", "price" to "8000円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "chi-gyu", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "直系二郎", "price" to "750円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "インスパイア二郎", "price" to "950円")
        menuList.add(menu)
        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(this, menuList, android.R.layout.simple_list_item_2, from, to)
        lvMenu.adapter = adapter
        setupClickListener(lvMenu)
    }

    private fun setupClickListener(view: ListView) {
        view.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener: AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            val menuName = item["name"]
            val menuPrice = item["price"]
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)
            startActivity(intent2MenuThanks)
        }
    }
}