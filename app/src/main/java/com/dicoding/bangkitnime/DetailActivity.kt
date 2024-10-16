package com.dicoding.bangkitnime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_KARAKTER = "extra_karakter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)

        val karakter = intent.getParcelableExtra<Karakter>(EXTRA_KARAKTER)

        karakter?.let {
            imgPhoto.setImageResource(it.photo)
            tvName.text = it.name
            tvDescription.text = it.description
        }
    }
}
