package com.example.crud_task.ui.activity

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_task.databinding.ActivityVechileBinding
import com.example.crud_task.model.VechileModel
import com.example.crud_task.repository.vechileRepositoryImpl
import com.example.crud_task.viewmodel.VechileViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class vechileActivty : AppCompatActivity() {
    lateinit var vechileBinding: ActivityVechileBinding
    var firebaseDatavbase : FirebaseDatabase = FirebaseDatabase.getInstance()
    val vechileRef = firebaseDatavbase.getReference("vechile")

    var firebaseStorage : FirebaseStorage = FirebaseStorage.getInstance()
    var storageReference : StorageReference = firebaseStorage.getReference()

    var imageUri : Uri? = null
    lateinit var  vechileModel: VechileModel
    lateinit var vechileViewModel: VechileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vechileBinding = ActivityVechileBinding.inflate(layoutInflater)
        setContentView(vechileBinding.root)


        var repo = vechileRepositoryImpl()
        vechileViewModel = VechileViewModel(repo)

    }

    fun uploadImage(){
        var vechileName = UUID.randomUUID().toString()
    }
    fun addVechile(url:String?,vechileName:String){
        var lisenNo : String = vechileBinding.tvVehicleInfo.text.toString()
        var data = VechileModel(vechileName,lisenNo,url ?:"")

        vechileRef.push().setValue(data).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                }

            }

        }
}