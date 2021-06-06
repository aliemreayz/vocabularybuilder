package com.example.vocabulary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*
import kotlinx.android.synthetic.main.recycler_row.view.recyclerViewTextView
import kotlinx.android.synthetic.main.recycler_row_category.view.*


class RecyclerAdapter(val itemList : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ItemVH>() {

    class ItemVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_category, parent, false)
        return ItemVH(itemView)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.itemView.textView2.text = itemList.get(position)
        holder.itemView.setOnClickListener{
            if(itemList.get(position) == "verbs"){
                val intent = Intent(holder.itemView.context, WordsActivity::class.java)
                intent.putExtra("category", "verbs")
                holder.itemView.context.startActivity(intent)
            }
            else if(itemList.get(position) == "adverbs"){
                val intent = Intent(holder.itemView.context, WordsActivity::class.java)
                intent.putExtra("category", "adverbs")
                holder.itemView.context.startActivity(intent)
            }
            else if(itemList.get(position) == "adjectives"){
                val intent = Intent(holder.itemView.context, WordsActivity::class.java)
                intent.putExtra("category", "adjectives")
                holder.itemView.context.startActivity(intent)

            }else if(itemList.get(position) == "phrases and idioms"){
                val intent = Intent(holder.itemView.context, WordsActivity::class.java)
                intent.putExtra("category", "phrases and idioms")
                holder.itemView.context.startActivity(intent)

            }else
            {
                val intent = Intent(holder.itemView.context, DeleteActivity::class.java)
                intent.putExtra("word", itemList.get(position))
                holder.itemView.context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}