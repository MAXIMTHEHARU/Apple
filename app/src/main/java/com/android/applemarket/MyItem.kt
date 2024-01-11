package com.android.applemarket

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.versionedparcelable.VersionedParcelize
import java.io.Serializable
import java.text.DecimalFormat


data class MyItem (
    val aIcon: Int,
    val aTitle: String,
    val aAddress: String,
    val aPrice: String,
    val alikeCnt : Int,
    val aCommentCnt : Int,
    val nickname: String,
    val detailText : String,
    val aLike : Boolean
) : Serializable

