package com.example.crud_task.repository

import android.net.Uri
import com.example.crud_task.model.BrandModel
import com.example.crud_task.model.VechileModel
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Vehicle

interface VechileRespositroy{
    fun addVechile(vechileModel: VechileModel, callback: (Boolean, String?) -> Unit)
    fun uploadVechile(VechileName:String, VechileUri: Uri, Callback :(Boolean, String?, String?)->Unit)
    fun getAll(callback: (List<VechileModel>?, Boolean, String?) -> Unit)
    fun updateVechile(id:Int,data:MutableMap<String,Any>?,callback: (Boolean, String?) -> Unit)
    fun delete(id:Int,callback: (Boolean, String?) -> Unit)
    fun deleteVechile(VechileName: String, callback: (Boolean, String?) -> Unit)

    fun addBrand(brandModel: BrandModel, callback: (Boolean, String?) -> Unit)

}
