package com.jeff_skillrill.marks.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeff_skillrill.marks.entity.Subject

@Dao
interface SubjectDao {

    @Insert
    fun addSubject(subject: Subject)

    @Delete
    fun deleteSubject(subject: Subject)

    @Query("select * from subjects")
    fun getAllSubject():List<Subject>

    @Query("select * from subjects where subject_id =:id")
    fun getSubjectById(id:Int): Subject

}