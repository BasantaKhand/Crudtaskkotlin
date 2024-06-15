package com.example.crud_task.repository
import android.net.Uri
import com.example.crud_task.model.VechileModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class vechileRepositoryImpl : VechileRespositroy{
    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref : DatabaseReference = firebaseDatabase.getReference("vechile")

    var firebaseStorage : FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef : StorageReference = firebaseStorage.getReference("vechile")
//    override fun addVechile(vechileModel: VechileModel, callback: () -> Unit) {
//        val id = ref.push().key.toString()
//        vechileModel.id = id
////
////        ref.child(id).setValue(vechileModel).addOnCompleteListener{
////            if(it.isSuccessful){
////                callback(true, "Success")
////            }else{
////                callback(false, it.exception.toString())
////            }
////        }
//        ref.child(id).setValue(vechileModel).addOnCompleteListener {
//            if (it.isSuccessful) {
//                callback()
//            } else {
//                callback()
//            }
//        }



//    }

    override fun addVechile(vechileModel: VechileModel, callback: (Boolean, String?) -> Unit) {
        var id = ref.push().key.toString()
        vechileModel.id = id
        ref.child(id).setValue(vechileModel).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Success")
            } else {
                callback(false, it.exception.toString())
            }
        }
    }

    override fun uploadVechile(
        VechileName: String,
        VechileUri: Uri,
        Callback: (Boolean, String?, String?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAll(callback: (List<VechileModel>?, Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun update(
        id: Int,
        data: MutableMap<String, Any>?,
        callback: (Boolean, String?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteVechile(VechileName: String, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }
}


