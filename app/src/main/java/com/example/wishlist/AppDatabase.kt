package com.example.wishlist


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//this class holds the database
/*AppDatabase defines the database configuration and serves as the app's
main access point to the persisted data*/
@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ItemDaoDao(): ItemDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "Item-db"

            ).build()
    }
}