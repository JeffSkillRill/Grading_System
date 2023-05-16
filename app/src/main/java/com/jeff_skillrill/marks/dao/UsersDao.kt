package com.jeff_skillrill.marks.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeff_skillrill.marks.entity.User
@Dao
interface UsersDao {
    @Query("select * from users")
    fun getAllUsers(): List<User>

    @Insert
    fun addUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query(
        "select * from users where user_id = :id"
    )
    fun getUsersById(id: Int): User

    @Query(
        "select * from users where login = :login AND password = :password"
    )
    fun getUser(login: String, password: String): User
}