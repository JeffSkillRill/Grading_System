package com.jeff_skillrill.marks.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentSubjectModelDao {

    //@Query("SELECT * FROM student_subject_table WHERE subject_id =:subjectID")
    //fun allPeopleFromSubject(subjectID: Int): LiveData<List<PersonModel>>

    @Query("SELECT * FROM person_table WHERE id IN (SELECT person_id FROM student_subject_table WHERE subject_id == :subjectID)")
    fun findPeopleFromSubject(subjectID: Int): LiveData<List<PersonModel>>


    @Query("SELECT * FROM person_table  EXCEPT SELECT * FROM person_table WHERE id IN (SELECT person_id FROM student_subject_table WHERE subject_id =:subjectID)")
    fun findPeopleNotFromSubject(subjectID: Int): LiveData<List<PersonModel>>

    @Query("SELECT * FROM subject_table WHERE id IN (SELECT subject_id FROM student_subject_table WHERE person_id == :personId)")
    fun findSubjectsForPerson(personId: Int): LiveData<List<SubjectModel>>

    @Query("Select * FROM student_subject_table Where person_id=:studentID")
    fun findRelationsByStudentID(studentID: Int): LiveData<List<StudentSubjectModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudentToSubject(studentSubjectModel: StudentSubjectModel)

    @Delete
    suspend fun removeStudentFromSubject(studentSubjectModel: StudentSubjectModel)

}