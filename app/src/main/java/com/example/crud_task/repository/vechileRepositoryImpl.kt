package com.example.crud_task.repository
import android.net.Uri
import com.example.crud_task.model.BrandModel
import com.example.crud_task.model.VechileModel
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Vehicle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class vechileRepositoryImpl : VechileRespositroy {
    var firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref: DatabaseReference = firebaseDatabase.getReference("vechile")
    private val db = FirebaseFirestore.getInstance()
    private val brandsCollection = db.collection("brands")

    var firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef: StorageReference = firebaseStorage.getReference("vechile")
//    override fun addVechile(vechile: Vehicle, callback: (Boolean, String?) -> Unit) {
//        TODO("Not yet implemented")
//    }
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
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var vechileList = mutableListOf<VechileModel>()

                for (eachData in snapshot.children) {
                    var vechile = eachData.getValue(VechileModel::class.java)
                    for (eachData in snapshot.children) {
                        var vechile = eachData.getValue(VechileModel::class.java)
                        if (vechile != null) {
                            vechileList.add(vechile)
                        }
                    }
//
                    callback(vechileList, true, "Success")


//                
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(null, false, "Unable to fetch products${error.message}")
            }

        })
    }

    override fun updateVechile(
        id: Int,
        data: MutableMap<String, Any>?,
        callback: (Boolean, String?) -> Unit
    ) {
        data?.let { // since that canot the load when it is null
            ref.child(id.toString()).updateChildren(it).addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "Data has been updatedq")
                } else {
                    callback(false, "Unable to update data")
                }
            }
        }
    }

    override fun delete(id: Int, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteVechile(VechileName: String, callback: (Boolean, String?) -> Unit) {
        ref.child(VechileName).removeValue().addOnCompleteListener {
            if (it.isSuccessful) {
                if (it.isSuccessful) {
                    callback(true, "Product deleted successfully")
                } else {
                    callback(false, "Unable to delete product")
                }
            }


        }
    }

    override fun addBrand(brandModel: BrandModel, callback: (Boolean, String?) -> Unit) {
        brandsCollection.add(brandModel)

        ref.child("brand").setValue(brandModel).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Success")
            } else {
                callback(false, it.exception.toString())
            }
        }
    }



}


