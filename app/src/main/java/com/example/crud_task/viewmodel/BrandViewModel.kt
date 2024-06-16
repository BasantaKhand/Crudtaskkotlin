package com.example.crud_task.viewmodel

import androidx.lifecycle.ViewModel
import com.example.crud_task.model.BrandModel
import com.example.crud_task.repository.vechileRepositoryImpl

class BrandViewModel (val repository : vechileRepositoryImpl) : ViewModel(){
    fun addBrand(brandModel : BrandModel, callback : (Boolean, String?) -> Unit){
        repository.addBrand(brandModel,callback)
    }
}