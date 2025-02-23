package com.vikination.githubsearchuserapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vikination.githubsearchuserapp.data.models.UserEntity
import com.vikination.githubsearchuserapp.data.source.local.dao.UserDao

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}