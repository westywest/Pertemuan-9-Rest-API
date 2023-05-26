package com.maharanid17.pertemuan9restapi.model.request


import com.google.gson.annotations.SerializedName

data class DetailDataMahasiswa(
    @SerializedName("NIM")
    val nIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)