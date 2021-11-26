package com.example.recycleviewkotlin

import android.os.Parcel
import android.os.Parcelable

data class hero(val foto: Int, val nama: String?, val deskripsi: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(foto)
        parcel.writeString(nama)
        parcel.writeString(deskripsi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<hero> {
        override fun createFromParcel(parcel: Parcel): hero {
            return hero(parcel)
        }

        override fun newArray(size: Int): Array<hero?> {
            return arrayOfNulls(size)
        }
    }
}