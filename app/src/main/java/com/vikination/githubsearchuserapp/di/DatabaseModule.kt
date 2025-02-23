package com.vikination.githubsearchuserapp.di

import android.content.Context
import androidx.room.Room
import com.vikination.githubsearchuserapp.data.source.local.AppDatabase
import com.vikination.githubsearchuserapp.data.source.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) : AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "user_github_database"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) : UserDao = database.userDao()
}