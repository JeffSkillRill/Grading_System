package com.jeff_skillrill.marks.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeff_skillrill.marks.model.SubjectModel

@Dao
interface SubjectModelDao {

    @Query("SELECT * FROM subject_table")
    fun allSubjects(): LiveData<List<SubjectModel>>

    @Query("SELECT * FROM subject_table WHERE id =:id")
    fun findSubjectById(id : Int): LiveData<SubjectModel>

    @Query("SELECT * FROM subject_table WHERE id IN (SELECT subject_id FROM grade_table WHERE id =:gradeID)")
    fun findSubjectByGradeID(gradeID: Int): LiveData<SubjectModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun addSubject(subject: SubjectModel)

    @Delete
    suspend fun removeSubject(subject: SubjectModel)

    @Update
    suspend fun update(subject: SubjectModel)
}