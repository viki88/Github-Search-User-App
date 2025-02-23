package com.vikination.githubsearchuserapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vikination.githubsearchuserapp.data.models.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllLocalUsers(): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM user WHERE username LIKE '%' || :query || '%'")
    fun searchUsers(query: String): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE username = :username LIMIT 1")
    fun getUserDetail(username: String): Flow<UserEntity?>

    @Query("DELETE FROM user")
    suspend fun clearUsers()

    @Update
    suspend fun updateUser(user: UserEntity)
}