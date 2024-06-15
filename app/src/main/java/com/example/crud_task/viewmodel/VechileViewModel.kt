package com.example.crud_task.viewmodel

import androidx.lifecycle.ViewModel
import com.example.crud_task.model.VechileModel
import com.example.crud_task.repository.vechileRepositoryImpl

class VechileViewModel(val repository : vechileRepositoryImpl) : ViewModel() {
    fun addVechile(vechileModel : VechileModel ,callback : (Boolean ,String?) -> Unit){
        repository.addVechile(vechileModel,callback)
    }

}