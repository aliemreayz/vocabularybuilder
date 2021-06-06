package com.example.vocabulary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter2(val itemList : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter2.ItemVH2>() {

    class ItemVH2(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH2 {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ItemVH2(itemView)
    }

    override fun onBindViewHolder(holder: ItemVH2, position: Int) {
        holder.itemView.recyclerViewTextView.text = itemList.get(position)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, WordActivity::class.java)
            intent.putExtra("word", itemList.get(position))
            holder.itemView.context.startActivity(intent)

        }

        holder.itemView.button7.setOnClickListener(){
            val intent = Intent(holder.itemView.context, AddActivity::class.java)
            intent.putExtra("word", itemList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}