package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlistItems: List<WishlistItem>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<android.widget.Button>(R.id.addItemButton)
        val editItemName = findViewById<android.widget.EditText>(R.id.editTextItemName)
        val editItemUrl = findViewById<android.widget.EditText>(R.id.editTextItemUrl)
        val editItemPrice = findViewById<android.widget.EditText>(R.id.editTextItemPrice)

        fun addItem(itemName: String, itemPrice: Float, itemUrl : String) : Unit {
            WishlistItemFetcher.itemNames.add(itemName)
            WishlistItemFetcher.itemPrices.add(itemPrice)
            WishlistItemFetcher.itemUrls.add(itemUrl)
        }

        button.setOnClickListener {
            val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
            val itemPriceFloat = editItemPrice.text.toString().toFloat();
            addItem(editItemName.text.toString(), itemPriceFloat, editItemUrl.text.toString())
            wishlistItems = WishlistItemFetcher.getWishListItems()
            val adapter = WishlistItemAdapter(wishlistItems)
            wishlistRv.adapter = adapter
            wishlistRv.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()


        }
    }
}