package com.jeff_skillrill.marks.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.jeff_skillrill.marks.entity.StudentGuruh

@Dao
interface StudentGuruhDao {


    @Insert
    fun addStudentGuruh(studentGuruh: StudentGuruh)

    @Delete
    fun deleteStudentGuruh(studentGuruh: StudentGuruh)




}