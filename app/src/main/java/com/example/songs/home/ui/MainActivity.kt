package com.example.songs.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.songs.R
import com.example.songs.home.data.Result
import com.example.songs.home.data.SongModel
import com.example.songs.home.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,SongListAdapter.HomeListener{

    private lateinit var vm:ViewModel
    private lateinit var adapter: SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[ViewModel.]

        initAdapter()

        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if (it!=null){
                adapter.setData(it as ArrayList<Result>)
            }else{
            }
        })
    }

    private fun initAdapter() {
        adapter = SongListAdapter(this)
        songsPlaylist.layoutManager = LinearLayoutManager(this)
        songsPlaylist.adapter = adapter
    }

    override fun onItemDeleted(postModel: Result, position: Int) {
        TODO("Not yet implemented")
    }

}