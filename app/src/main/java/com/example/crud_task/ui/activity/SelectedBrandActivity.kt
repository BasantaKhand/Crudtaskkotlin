package com.example.crud_task.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_task.databinding.ActivitySelectedBrandBinding

class SelectedBrandActivity : AppCompatActivity() {
    private lateinit var selectedBrandBinding: ActivitySelectedBrandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        selectedBrandBinding = ActivitySelectedBrandBinding.inflate(layoutInflater)
        setContentView(selectedBrandBinding.root)

        val brandName = intent.getStringExtra("BRAND_NAME")
        val brandImageResID = intent.getIntExtra("BRAND_IMAGES", 0)

        selectedBrandBinding.textViewBrandName.text = brandName
        if (brandImageResID != 0) {
            selectedBrandBinding.imageViewBrand.setImageResource(brandImageResID)
        }

        selectedBrandBinding.textViewBrandName.setOnClickListener{
            var intent = Intent(this,vechileActivty::class.java)
            startActivity(intent)
        }
    }
}

