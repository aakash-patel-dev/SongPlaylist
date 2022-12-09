package com.example.songs.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.songs.home.data.HomeRepository
import com.example.songs.home.data.SongModel

class ViewModel {

    private var homeRepository: HomeRepository?=null
    var postModelListLiveData : LiveData<List<SongModel>>?=null


    init {
        homeRepository = HomeRepository()
        postModelListLiveData = MutableLiveData()

    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }
}