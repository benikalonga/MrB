package com.beni.mrben.data

import androidx.room.Entity

@Entity(tableName = "user_table")
data class User(val id: Int, val name: String, val email: String)