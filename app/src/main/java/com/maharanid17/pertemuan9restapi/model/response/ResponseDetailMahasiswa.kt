package com.maharanid17.pertemuan9restapi.model.response


import com.google.gson.annotations.SerializedName
import com.maharanid17.pertemuan9restapi.model.request.DetailDataMahasiswa

data class ResponseDetailMahasiswa(
    @SerializedName("data")
    val data: DetailDataMahasiswa,
    @SerializedName("status")
    val status: String
)