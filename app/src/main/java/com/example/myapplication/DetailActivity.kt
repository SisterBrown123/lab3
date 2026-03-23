package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dayNumber = intent.getIntExtra("day_number", 1)
        val titleResId = intent.getIntExtra("title_res", 0)
        val imageResId = intent.getIntExtra("image_res", 0)
        val fullDescResId = intent.getIntExtra("full_desc_res", 0)

        val toolbar = findViewById<MaterialToolbar>(R.id.detailToolbar)
        toolbar.title = getString(R.string.detail_toolbar_title, dayNumber)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image = findViewById<ImageView>(R.id.detailImage)
        val dayBadge = findViewById<TextView>(R.id.detailDayBadge)
        val title = findViewById<TextView>(R.id.detailTitle)
        val fullDesc = findViewById<TextView>(R.id.detailFullDesc)

        image.setImageResource(imageResId)
        dayBadge.text = getString(R.string.day_format, dayNumber)
        title.text = getString(titleResId)
        fullDesc.text = getString(fullDescResId)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
