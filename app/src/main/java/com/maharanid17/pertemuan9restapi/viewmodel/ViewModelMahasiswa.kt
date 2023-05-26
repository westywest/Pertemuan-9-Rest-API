package com.maharanid17.pertemuan9restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maharanid17.pertemuan9restapi.model.request.DataMahasiswa
import com.maharanid17.pertemuan9restapi.model.response.ResponseDataMahasiswa
import com.maharanid17.pertemuan9restapi.model.response.ResponseDetailMahasiswa
import com.maharanid17.pertemuan9restapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMahasiswa : ViewModel() {
    private val getDataMahasiswa = MutableLiveData<List<DataMahasiswa>?>()
    private val getDetailDataMahasiswa = MutableLiveData<ResponseDetailMahasiswa?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataMahasiswa>?>{
        return getDataMahasiswa

    }

    fun getDetailDataMahasiswa() : MutableLiveData<ResponseDetailMahasiswa?>{
        return getDetailDataMahasiswa
    }

    fun showDataMahasiswa(){
        ApiClient.instance.getDataMahasiswa().enqueue(object : Callback<ResponseDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataMahasiswa>,
                response: Response<ResponseDataMahasiswa>
            ) {
                if (response.isSuccessful){
                    getDataMahasiswa.postValue(response.body()?.data)
                }else{
                    getDataMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataMahasiswa>, t: Throwable) {
                getDataMahasiswa.postValue(null)
            }

        })
    }

    fun getDetailData(nim : String){
        ApiClient.instance.getDetailMahasiswa(nim).enqueue(object : Callback<ResponseDetailMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDetailMahasiswa>,
                response: Response<ResponseDetailMahasiswa>
            ) {
                if(response.isSuccessful){
                    getDetailDataMahasiswa.postValue(response.body())
                }else{
                    getDetailDataMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDetailMahasiswa>, t: Throwable) {
                getDetailDataMahasiswa.postValue(null)
            }

        })
    }
}