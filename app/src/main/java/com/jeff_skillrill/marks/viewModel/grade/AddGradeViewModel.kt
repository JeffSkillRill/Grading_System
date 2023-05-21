package com.jeff_skillrill.marks.viewModel.grade

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jeff_skillrill.marks.model.GradeModel
import com.jeff_skillrill.marks.model.MyDatabase
import com.jeff_skillrill.marks.model.repositories.GradeRepository
import kotlinx.coroutines.launch

class AddGradeViewModel(application: Application) : AndroidViewModel(application) {

    val gradeRepository: GradeRepository


    init{
        gradeRepository = GradeRepository(MyDatabase.getDatabase(application).gradeModelDao())
    }

    fun addGrade(grade : GradeModel){
    viewModelScope.launch{
            gradeRepository.add(grade)
        }
    }
}