package com.example.crud_task.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_task.R
import com.example.crud_task.databinding.ActivityBrandBinding

class BrandActivity : AppCompatActivity() {
    lateinit var brandBinding: ActivityBrandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        BrandBinding = ActivityBrandSelectionBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        brandBinding = ActivityBrandBinding.inflate(layoutInflater)
        setContentView(brandBinding.root)

    }
}