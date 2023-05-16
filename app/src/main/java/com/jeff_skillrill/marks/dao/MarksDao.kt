package com.jeff_skillrill.marks.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.jeff_skillrill.marks.entity.Marks

@Dao
interface MarksDao {

    @Insert
    fun addMarks(marks: Marks)

    @Delete
    fun deleteMarks(marks: Marks)

}