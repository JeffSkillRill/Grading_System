package com.jeff_skillrill.marks.viewModel.grade

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.jeff_skillrill.marks.model.GradeModel
import com.jeff_skillrill.marks.model.MyDatabase
import com.jeff_skillrill.marks.model.repositories.GradeRepository
import kotlinx.coroutines.launch

class EditGradeViewModel(application: Application) : AndroidViewModel(application) {

    val _gradeRepository: GradeRepository = GradeRepository(MyDatabase.getDatabase(application).gradeModelDao())
    private lateinit var _currentGrade: LiveData<GradeModel>


    fun update(grade: GradeModel) {
        viewModelScope.launch {
            _gradeRepository.update(grade)
        }
    }

    fun getGrade(gradeID: Int): LiveData<GradeModel>{
        _currentGrade = _gradeRepository.findGradeById(gradeID)
        return _currentGrade
    }


}