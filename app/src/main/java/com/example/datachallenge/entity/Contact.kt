package com.example.datachallenge.entity

import android.os.Parcel
import android.os.Parcelable

data class Contact(val name:String?, val msj:String?,val time:Int?, val urlImage:String?):Parcelable {
//    var name: String = ""
//    var msj: String= ""
//    var time: Int = 0
//    var urlImage:String = ""
    constructor(parcel: Parcel) : this(
       parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}