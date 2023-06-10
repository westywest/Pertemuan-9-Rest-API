package com.maharanid17.pertemuan9restapi.network

import com.maharanid17.pertemuan9restapi.model.response.ResponseDeleteMahasiswa
import com.maharanid17.pertemuan9restapi.model.response.ResponseUpdateMahasiswa
import com.maharanid17.pertemuan9restapi.model.request.MahasiswaData
import com.maharanid17.pertemuan9restapi.model.response.ResponseAddMahasiswa
import com.maharanid17.pertemuan9restapi.model.response.ResponseDataMahasiswa
import com.maharanid17.pertemuan9restapi.model.response.ResponseDetailMahasiswa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET("datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim") nim : String ) : Call<ResponseDetailMahasiswa>

    @POST("datamahasiswa/")
    fun addDataMahasiswa(@Body data : MahasiswaData) : Call<ResponseAddMahasiswa>

    @POST("datamahasiswa/{nim}")
    fun updateDataMahasiswa(@Path("nim") nim : String, @Body data : MahasiswaData) : Call<ResponseUpdateMahasiswa>

    @DELETE("datamahasiswa/{nim}")
    fun deleteDataMahasiswa(@Path("nim") nim : String) : Call<ResponseDeleteMahasiswa>
}