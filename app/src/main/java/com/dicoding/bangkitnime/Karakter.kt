package com.dicoding.bangkitnime

import android.os.Parcelable
import android.os.Parcel;
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakter(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
