package com.example.contactmanagerapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//Dao is interface where we define functions to access the database
@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User): Long
    //suspend fun is used for executing a long running operation. it can be paused and resumed at a later time
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    // or we can make sql costume query
    @Query("DELETE FROM user_info")
    suspend fun deleteAll()
    @Query("SELECT * FROM USER_INFO")
    fun getAllUsersFromDB(): LiveData<List<User>>
}