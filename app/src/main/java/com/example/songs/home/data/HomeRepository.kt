package com.example.songs.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.songs.network.ApiClient
import com.example.songs.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {
    private var apiInterface: ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllPosts(): LiveData<List<SongModel>> {
        val data = MutableLiveData<List<SongModel>>()

        apiInterface?.fetchAllPosts("jack",50)?.enqueue(object : Callback<List<SongModel>> {

            override fun onFailure(call: Call<List<SongModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<SongModel>>,
                response: Response<List<SongModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        return data

    }

}