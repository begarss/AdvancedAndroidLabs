package com.example.studentlistmvvm.model.dataClass

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Student(
    var id: Int,
    var name: String?,
    var surname: String?,
    var age: Int,
    var email: String?,
    var city: String?,
    @SerializedName("univer")
    var univercity: String?,
    var hobby: String?,
    var dream: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeInt(age)
        parcel.writeString(email)
        parcel.writeString(city)
        parcel.writeString(univercity)
        parcel.writeString(hobby)
        parcel.writeString(dream)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }

}