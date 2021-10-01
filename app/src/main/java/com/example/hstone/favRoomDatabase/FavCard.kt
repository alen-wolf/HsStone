package com.example.hstone.favRoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_cards")
data class FavCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val cardSet: String?,
    val type: String?,
    val text: String?,
    val img: String="",
    val local: String?
)