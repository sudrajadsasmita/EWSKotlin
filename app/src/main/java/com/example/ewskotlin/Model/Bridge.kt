package com.example.ewskotlin.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bridge(
    var menuName: String? = null,
    var logo: Int? = null,
    var url: String? = null
) : Parcelable
