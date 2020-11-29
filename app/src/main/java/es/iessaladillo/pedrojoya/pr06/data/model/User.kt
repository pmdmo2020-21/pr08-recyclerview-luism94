package es.iessaladillo.pedrojoya.pr06.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var id:Long, var nombre:String, var email:String, var phoneNumber:String, var adress: String, var web:String, var photoUrl:String) : Parcelable