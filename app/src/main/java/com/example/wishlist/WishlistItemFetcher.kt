package com.example.wishlist

import android.provider.ContactsContract

class WishlistItemFetcher {
    companion object {
        val itemNames = mutableListOf<String>()
        val itemPrices = mutableListOf<Float>()
        val itemUrls = mutableListOf<String>()
        fun getWishListItems(): MutableList<WishlistItem> {
            var items : MutableList<WishlistItem> = ArrayList()
            for (i in itemNames.indices) {
                val item = WishlistItem(itemNames[i], itemPrices[i], itemUrls[i])
                items.add(item)
            }
            return items
        }
    }
}