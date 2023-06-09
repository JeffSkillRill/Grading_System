package com.jeff_skillrill.marks.model.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jeff_skillrill.marks.model.GradeModel
import com.jeff_skillrill.marks.model.GradeModelDao

class GradeRepository(private val gradeModelDao: GradeModelDao) {

    fun readAllGradeForStudent(personID: Int, subjectID: Int)
    = gradeModelDao.allStudentGrades(personID,subjectID);

    fun findGradeById(gradeID: Int)
    = gradeModelDao.findGradeById(gradeID)

    fun readAllGradeForStudent(personID: Int)
    =gradeModelDao.completelyAllStudentGrades(personID)

    fun findGradesByDate(gradeDate: String)
    = gradeModelDao.findGradesByDate(gradeDate)

    fun findGradesBySubject(subjectID: Int)
    = gradeModelDao.findGradesBySubject(subjectID)

    suspend fun add(grade: GradeModel){
        gradeModelDao.addGrade(grade)
    }

    suspend fun delete(grade: GradeModel) {
        gradeModelDao.deleteGrade(grade)
    }



    suspend fun update(grade: GradeModel) = gradeModelDao.update(grade)
}