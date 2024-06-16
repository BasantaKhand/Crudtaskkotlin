package com.example.crud_task.model

import android.os.Parcel
import android.os.Parcelable
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Vehicle

data class VechileModel(
    var id: String,
    val name: String,
    val licensePlate: String,
    val imageUrl: String? = null // Added for image URL
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString() // For the image URL (nullable)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(licensePlate)
        parcel.writeString(imageUrl) // Write the image URL
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vehicle> {
        override fun createFromParcel(parcel: Parcel): Vehicle {
            return VechileModel.createFromParcel(parcel)
        }

        override fun newArray(size: Int): Array<Vehicle?> {
            return arrayOfNulls(size)
        }
    }
}
