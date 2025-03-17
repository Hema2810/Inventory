package com.example.inventory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter( private val context: Context,private val list: List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.id.text = context.getString(R.string.id, item.id)
        holder.listId.text = context.getString(R.string.listid, item.listId)
        holder.name.text = context.getString(R.string.name, item.name)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView = itemView.findViewById(R.id.textViewId)
        val listId : TextView = itemView.findViewById(R.id.textViewListId)
        val name : TextView = itemView.findViewById(R.id.textViewName)
    }
}
