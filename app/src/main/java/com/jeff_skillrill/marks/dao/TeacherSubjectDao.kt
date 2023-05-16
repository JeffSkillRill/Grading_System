package com.jeff_skillrill.marks.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeff_skillrill.marks.entity.TeacherSubject

@Dao
interface TeacherSubjectDao {

    @Insert
    fun addTeacherSubjec(teacherSubject: TeacherSubject)

    @Delete
    fun deleteTeacherSubject(teacherSubject: TeacherSubject)


    @Query("select * from teacher_subjects where teacher_id = :id")
    fun getTeacherSubjectById(id:Int): TeacherSubject

}