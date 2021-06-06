package com.example.vocabulary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*
import kotlinx.android.synthetic.main.recycler_row.view.recyclerViewTextView
import kotlinx.android.synthetic.main.recycler_row_category.view.*
import kotlinx.android.synthetic.main.recycler_row_list.view.*

class RecyclerAdapter3(val itemList : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter3.ItemVH>() {

    class ItemVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_list, parent, false)
        return ItemVH(itemView)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.itemView.textView9.text = itemList.get(position)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ListWordActivity::class.java)
            intent.putExtra("word", itemList.get(position))
            holder.itemView.context.startActivity(intent)

        }

        holder.itemView.button8.setOnClickListener(){
            val intent = Intent(holder.itemView.context, DeleteActivity::class.java)
            intent.putExtra("word", itemList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}