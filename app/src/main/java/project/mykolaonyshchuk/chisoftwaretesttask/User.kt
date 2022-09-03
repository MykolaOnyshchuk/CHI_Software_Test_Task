package project.mykolaonyshchuk.chisoftwaretesttask

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import androidx.annotation.RequiresApi

class User: Parcelable {
    var name: String?
    var age: Int = 0
    var isStudent = false

    constructor(name: String?, age: Int, isStudent: Boolean) {
        this.name = name
        this.age = age
        this.isStudent = isStudent
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(input: Parcel) {
        name = input.readString()
        age = input.readInt()
        isStudent = input.readBoolean()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name)
        p0?.writeInt(age)
        p0?.writeBoolean(isStudent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<User> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}