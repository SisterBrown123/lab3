package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tipsList = TipsDataSource.getTips()
        val adapter = TipAdapter(tipsList) { tip ->
            openDetail(tip)
        }
        recyclerView.adapter = adapter
    }

    private fun openDetail(tip: Tip) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("day_number", tip.dayNumber)
        intent.putExtra("title_res", tip.titleResId)
        intent.putExtra("image_res", tip.imageResId)
        intent.putExtra("full_desc_res", tip.fullDescResId)
        startActivity(intent)
    }
}
