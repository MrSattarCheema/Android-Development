package com.example.contactmanagerapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user_info")
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") //to assign custom name of column otherwise it would set val name as column name
    val id: Int,
    var name: String,
    var number: String
)