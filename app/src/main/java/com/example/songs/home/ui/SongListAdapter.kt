package com.example.songs.home.ui



import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.songs.R
import com.example.songs.home.data.Result
import com.example.songs.home.data.SongModel


class SongListAdapter(var listener:HomeListener) : RecyclerView.Adapter<SongListAdapter.HomeViewHolder>(){

    private var data : ArrayList<Result>?=null

    interface HomeListener{
        fun onItemDeleted(postModel: Result, position: Int)
    }

    fun setData(list: ArrayList<Result>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
        holder.itemView.rootView.setOnClickListener {
            item.let { it1 ->
                listener.onItemDeleted(it1!!, position)
            }
        }
    }

    fun addData(postModel: Result) {
        data?.add(0,postModel)
        notifyItemInserted(0)
    }

    fun removeData(position: Int) {
        data?.removeAt(position)
        notifyDataSetChanged()
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: Result?) {
           var textSongTitle : TextView =  itemView.findViewById(R.id.songTitle)
           var textSongDesc : TextView = itemView.findViewById(R.id.songDesc)

            textSongTitle.text = item!!.artistName
            textSongDesc.text = item.shortDescription
        }

    }

}