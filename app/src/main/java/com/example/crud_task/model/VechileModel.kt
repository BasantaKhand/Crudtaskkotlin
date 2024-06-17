package com.example.crud_task.model

import android.os.Parcel
import android.os.Parcelable
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Vehicle

data class VechileModel(
    var id: String? = null,
    val name: String? = null,
    val licensePlate: String? = null,
    val color: String? = null
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(licensePlate)
        parcel.writeString(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VechileModel> {
        override fun createFromParcel(parcel: Parcel): VechileModel {
            return VechileModel(parcel)
        }

        override fun newArray(size: Int): Array<VechileModel?> {
            return arrayOfNulls(size)
        }
    }

}