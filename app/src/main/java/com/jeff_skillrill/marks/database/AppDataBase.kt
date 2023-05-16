package com.jeff_skillrill.marks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jeff_skillrill.marks.dao.UsersDao
import com.jeff_skillrill.marks.entity.*


@Database(entities = [User::class, Guruh::class, Marks::class, StudentGuruh::class, Subject::class, TeacherSubject::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
//teach1
    companion object{
        var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase{
            if(instance==null){
                instance = Room.databaseBuilder(context, AppDataBase::class.java, "app_db").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
   
}