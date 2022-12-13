package com.example.roomdatabaseexample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class,Users::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO():ContactDAO
}