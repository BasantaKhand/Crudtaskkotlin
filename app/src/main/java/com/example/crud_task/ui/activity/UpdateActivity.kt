package com.example.crud_task.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_task.databinding.ActivityUpdateBinding
import com.example.crud_task.viewmodel.VechileViewModel

class UpdateActivity : AppCompatActivity() {
    lateinit var updateBinding: ActivityUpdateBinding
    lateinit var vechileViewModel: VechileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        updateBinding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(updateBinding.root)



    }

    fun updateVechile(){
        var updateName = updateBinding.updateVechileNumber.editText.toString()
        var updateNumber = updateBinding.updateVechileNumber.editText.toString()
        var updateResgister = updateBinding.updateRegisterNo.editText.toString()

        var updateMap = mutableMapOf<String,Any>()
        updateMap["name"] = updateName
        updateMap["number"] = updateNumber
        updateMap["register"] = updateResgister

//        vechileViewModel.updateVechile(id.toString() ,updateMap)




    }



}