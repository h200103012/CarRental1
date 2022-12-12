package com.example.carrental.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carrental.APP
import com.example.carrental.R
import com.example.carrental.favoriteFragment
import com.example.carrental.model.FavModel
import kotlinx.android.synthetic.main.item_layout.view.*

class FavAdapter: RecyclerView.Adapter<FavAdapter.FavViewHolder>() {

    var listFav = emptyList<FavModel>()

    class FavViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.itemView.item_title.text = listFav[position].title
        holder.itemView.setOnClickListener {
            Toast.makeText(APP, "$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listFav.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FavModel>) {
        listFav = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: FavViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            favoriteFragment.clickFav(listFav[holder.adapterPosition])

        }
    }

    override fun onViewDetachedFromWindow(holder: FavViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}