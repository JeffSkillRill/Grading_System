package com.jeff_skillrill.marks.model.repositories

import androidx.lifecycle.LiveData
import com.jeff_skillrill.marks.model.PersonModel
import com.jeff_skillrill.marks.model.PersonModelDao

class PersonRepository(private val personModelDao : PersonModelDao) {
    val readAll: LiveData<List<PersonModel>> = personModelDao.allPeople()

    fun findPersonById(id: Int): LiveData<PersonModel> = personModelDao.findPersonById(id)

    fun findPersonByGrade(gradeID: Int): LiveData<PersonModel> = personModelDao.findPersonByGradeID(gradeID)

    suspend fun delete(student: PersonModel) = personModelDao.deletePerson(student)

    suspend fun add(student: PersonModel) = personModelDao.insertPerson(student)

    suspend fun update(student: PersonModel) = personModelDao.update(student)
}