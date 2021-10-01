package com.example.hstone.favRoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavCard::class], version = 1,exportSchema = false)
abstract class FavCardDatabase :RoomDatabase() {

    abstract val  favCardDao: FavCardDao

    companion object{

        @Volatile
        private var INSTANCE: FavCardDatabase? = null

        fun getInstance(context: Context): FavCardDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavCardDatabase::class.java,
                    "favourite_cards"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }

    }

}