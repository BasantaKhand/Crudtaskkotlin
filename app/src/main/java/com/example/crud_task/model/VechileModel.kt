package com.example.crud_task.model

import android.os.Parcel
import android.os.Parcelable

data class VechileModel(
    var id : String,
    val name :String,
    val licensePlate :String,
//    val blueBookRenewDays : Int,
//    val regularServicingDays : Int,
//    val drivingCost : Int,
//    val avgMileage : Int,
//    val lifeTimeCost : Float,
//    val lifeTimeFloat : Float,
//    val lifeTimeDistance : Float
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readFloat(),
//        parcel.readFloat(),
//        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(licensePlate)
//        parcel.writeInt(blueBookRenewDays)
//        parcel.writeInt(regularServicingDays)
//        parcel.writeInt(drivingCost)
//        parcel.writeInt(avgMileage)
//        parcel.writeFloat(lifeTimeCost)
//        parcel.writeFloat(lifeTimeFloat)
//        parcel.writeFloat(lifeTimeDistance)
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
