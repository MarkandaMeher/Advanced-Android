package com.example.roomdatabaseexample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact():LiveData<List<Contact>>

    @Query("SELECT * FROM contact WHERE name=:name")
    fun getNameData(name: String):LiveData<List<Contact>>

    @Insert
    suspend fun insertUsers(users: Users)
}