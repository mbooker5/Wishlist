package com.example.wishlist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM calorie_table")
    fun getAll(): Flow<List<ItemEntity>>

    @Insert
    fun insertAll(entries: List<ItemEntity>)

    @Query("DELETE FROM calorie_table")
    fun deleteAll()
}