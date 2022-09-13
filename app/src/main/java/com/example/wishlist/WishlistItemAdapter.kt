package com.example.wishlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WishlistItemAdapter (private val items: List<WishlistItem>) : RecyclerView.Adapter<WishlistItemAdapter.ViewHolder>(){
    class ViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: android.widget.TextView
        val priceTextView: android.widget.TextView
        val urlTextView: android.widget.TextView

        init {
            nameTextView = itemView.findViewById(R.id.itemName)
            priceTextView = itemView.findViewById(R.id.itemPrice)
            urlTextView = itemView.findViewById(R.id.itemUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = android.view.LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = items.get(position)
        holder.nameTextView.text = items.itemName
        holder.priceTextView.text = items.itemPrice.toString()
        holder.urlTextView.text = items.itemUrl
    }

    override fun getItemCount(): Int {
        return items.size
    }
}