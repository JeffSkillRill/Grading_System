package com.jeff_skillrill.marks.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeff_skillrill.marks.model.PersonModel

@Dao
interface PersonModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(student: PersonModel)

    @Delete
    suspend fun deletePerson(student: PersonModel)

    @Query("SELECT * FROM person_table WHERE id IN (SELECT person_id FROM grade_table WHERE id =:gradeID)")
    fun findPersonByGradeID(gradeID: Int): LiveData<PersonModel>

    @Query("SELECT * FROM person_table")
    fun allPeople(): LiveData<List<PersonModel>>

    @Query("SELECT * FROM person_table WHERE id =:id")
    fun findPersonById(id : Int): LiveData<PersonModel>

    @Update
    suspend fun update(person: PersonModel)
}