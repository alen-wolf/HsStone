package com.example.hstone.favRoomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavCardDao {

    @Query("SELECT * FROM favourite_cards")
    fun getAllCards(): List<FavCard>

    @Insert
    fun insertCard(favCard: FavCard)

    @Query("DELETE FROM favourite_cards")
    fun clear()
}