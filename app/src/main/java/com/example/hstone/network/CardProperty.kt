package com.example.hstone.network

import android.os.Parcelable
import android.util.Log
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardProperty (
    val name: String,
    val cardSet: String?,
    val type: String?,
    val text: String?,
    @Json(name="img") val imgSrcUrl: String="",
    val local: String?
):Parcelable{}

