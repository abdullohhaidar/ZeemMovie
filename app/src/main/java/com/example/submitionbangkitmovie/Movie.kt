package com.example.submitionbangkitmovie

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val name: String?,
    val description: String?,
    val years: String?,
    val genre: String?,
    val duration: String?,
    val director: String?,
    val caster: String?,
    val distributor: String?,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(years)
        parcel.writeString(genre)
        parcel.writeString(duration)
        parcel.writeString(director)
        parcel.writeString(caster)
        parcel.writeString(distributor)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}