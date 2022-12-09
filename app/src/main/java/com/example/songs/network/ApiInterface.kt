package com.example.songs.network

import com.example.songs.home.data.SongModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("search/")
    fun fetchAllPosts(@Path("term") term:String,@Path("limit")  limit:Int) : Call<List<SongModel>>
}