package com.example.contactmanagerapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDAO: UserDAO

    //Singleton design pattern
    companion object {
//Companion objects are used to create class level properties and are accessible with class name without of creating object
        //they are used to declare static members in kotlin
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
//The synchronized keyword is used to ensure that only one thread can enter this block at a time, preventing multiple threads from creating multiple instances of the database.
                var instance = INSTANCE
                if (instance == null) {
                    //creating database Object if already not exist
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_DB"
                    ).build()
                }
                return instance
            }
        }
    }
}