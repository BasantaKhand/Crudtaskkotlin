package com.example.crud_task.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_task.databinding.ActivityVechileBinding
import com.example.crud_task.model.VechileModel
import com.example.crud_task.repository.vechileRepositoryImpl
import com.example.crud_task.viewmodel.VechileViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class vechileActivty : AppCompatActivity() {
    lateinit var vechileBinding: ActivityVechileBinding
    var firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val vechileRef : DatabaseReference= firebaseDatabase.reference.child("vechile")
//    var ref: DatabaseReference = firebaseDatabase.reference.child("products")
    var repository = vechileRepositoryImpl()
    lateinit var vechileViewModel: VechileViewModel

//    private var colorList = arrayListOf("Red", "Blue", "Green", "Yellow", "Black", "White", "Orange", "Pink", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vechileBinding = ActivityVechileBinding.inflate(layoutInflater)
        setContentView(vechileBinding.root)

        var repo = vechileRepositoryImpl()
        vechileViewModel = VechileViewModel(repo)

        vechileBinding.registerBike.setOnClickListener {
            addVechile()
        }
    }

    fun addVechile() {
        val vechileColor = vechileBinding.textViewColor.editText!!.text.toString()
        val licenseNo = vechileBinding.textInputLayout2.editText!!.text.toString()
        val regNumber = vechileBinding.textVechileNumber.editText!!.text.toString()

        if (vechileColor.isNotEmpty() && licenseNo.isNotEmpty() && regNumber.isNotEmpty()) {
            val vechileData = VechileModel("", vechileColor, licenseNo, regNumber)
            vechileViewModel.addVechile(vechileData) { success, message ->
                if (success) {
                    Toast.makeText(applicationContext, "Vehicle added successfully!", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }
}
