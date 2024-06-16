package com.example.crud_task

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_task.databinding.ActivityMainBinding
import com.example.crud_task.databinding.DailogAddVechileBinding
import com.example.crud_task.ui.activity.BrandActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.ivAdd.setOnClickListener {
            showAddVehicleDialog()
        }
    }

    private fun showAddVehicleDialog() {
        val dialogBinding = DailogAddVechileBinding.inflate(LayoutInflater.from(this))
        val builder = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setTitle("Add Vehicle")
        val alertDialog = builder.show()

        val launchBrandActivity = {
            alertDialog.dismiss() // Dismiss the dialog before starting the new activity
            val intent = Intent(this, BrandActivity::class.java)
            startActivity(intent)
        }

        dialogBinding.buttonAddBike.setOnClickListener {
            launchBrandActivity()
        }

        dialogBinding.buttonAddScooter.setOnClickListener {
            launchBrandActivity()
        }
    }
}

