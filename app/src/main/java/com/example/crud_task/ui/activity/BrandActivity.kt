package com.example.crud_task.ui.activity

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.crud_task.R
import com.example.crud_task.adapter.BrandAdapter
import com.example.crud_task.databinding.ActivityBrandBinding
import com.example.crud_task.model.BrandModel
import com.example.crud_task.repository.VechileRespositroy
import com.example.crud_task.repository.vechileRepositoryImpl
import com.example.crud_task.viewmodel.BrandViewModel
import com.example.crud_task.viewmodel.VechileViewModel

class BrandActivity : AppCompatActivity() {
    private lateinit var brandBinding: ActivityBrandBinding
    private val vechileViewModel: VechileViewModel by viewModels()
    private lateinit var gridView: GridView
    lateinit var brandViewModel: BrandViewModel
    private val repository = vechileRepositoryImpl()
//    private lateinit var main: androidx.constraintlayout.widget.ConstraintLayout

    private var nameList = arrayListOf("Ducati", "Honda", "Suzuki", "Yamaha")
    private var imageList = arrayListOf(R.drawable.ducati, R.drawable.honda, R.drawable.suzuki, R.drawable.yamaha)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        brandBinding = ActivityBrandBinding.inflate(layoutInflater)
        setContentView(brandBinding.root)

        // Assuming main is defined in your binding layout

        gridView = brandBinding.gridViewBrands // Assuming gridViewBrands is defined in your binding layout


        val adapter = BrandAdapter(this, nameList, imageList)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView, view, position, id->
            val name = nameList[position]
            val image = imageList[position].toInt()
            Toast.makeText(applicationContext, name, Toast.LENGTH_LONG).show()
//
            val brandModel = BrandModel(id = "", name = name, imageResId = image)
            repository.addBrand(brandModel) { success, errorMessage ->
                if (success) {
                    Toast.makeText(this, "Brand added successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}