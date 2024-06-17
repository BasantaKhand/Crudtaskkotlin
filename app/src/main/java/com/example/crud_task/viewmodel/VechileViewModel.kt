package com.example.crud_task.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_task.model.VechileModel
import com.example.crud_task.repository.vechileRepositoryImpl
class VechileViewModel(val repository : vechileRepositoryImpl) : ViewModel() {
    fun addVechile(vechileModel: VechileModel, callback: (Boolean, String?) -> Unit){
        repository.addVechile(vechileModel,callback)
    }

    var vechileList = MutableLiveData<List<VechileModel>>()


    fun deleteVechile(id:String, callback: (Boolean, String?) -> Unit){
        repository.deleteVechile(id,callback)
    }

    fun fetchAllVechile(){
        repository.getAll{ vechile, sucess, message ->
            if (vechile != null) {
                //once the image is fetch
                vechileList.value = vechile
            }
        }
    }

    fun updateVechile(id:String, data: MutableMap<String, Any>?, callback: (Boolean, String?) -> Unit){
        repository.updateVechile(id.toInt(),data,callback)
    }



}