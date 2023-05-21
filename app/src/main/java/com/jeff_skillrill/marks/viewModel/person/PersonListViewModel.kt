package com.jeff_skillrill.marks.viewModel.person

import android.app.Application
import androidx.lifecycle.*
import com.jeff_skillrill.marks.model.MyDatabase
import com.jeff_skillrill.marks.model.PersonModel
import com.jeff_skillrill.marks.model.SubjectModel
import com.jeff_skillrill.marks.model.repositories.PersonRepository
import com.jeff_skillrill.marks.model.repositories.StudentSubjectRepository
import com.jeff_skillrill.marks.model.repositories.SubjectRepository
import kotlinx.coroutines.launch

class PersonListViewModel(application: Application): AndroidViewModel(application){

    private var _mainList: LiveData<List<PersonModel>>
    private val _StudentSubjectRepository: StudentSubjectRepository
    private val _subjectRepository: SubjectRepository
    private val _personRepository: PersonRepository
    private var _currentPerson: LiveData<PersonModel>? = null
    private var _currentSubject: LiveData<SubjectModel>

    init {
        _StudentSubjectRepository = StudentSubjectRepository(MyDatabase.getDatabase(application).studentSubjectModelDao())
        _mainList = _StudentSubjectRepository.findPeopleFromSubject(0)
        _personRepository = PersonRepository(MyDatabase.getDatabase(application).personModelDao())
        _subjectRepository = SubjectRepository(MyDatabase.getDatabase(application).subjectModelDao())
        _currentSubject = _subjectRepository.findSubjectById(0)
    }

    val allStudentsFromSubject: LiveData<List<PersonModel>>
        get() = _mainList

    val currentSubject: LiveData<SubjectModel>
        get() = _currentSubject


    fun setSubject(subjectId: Int){
        _currentSubject = _subjectRepository.findSubjectById(subjectId)
        _mainList = _StudentSubjectRepository.findPeopleFromSubject(subjectId)
    }

    val currentPerson: LiveData<PersonModel>?
        get() = _currentPerson

    fun setCurrentPerson(id: Int){
        _currentPerson = _personRepository.findPersonById(id)
    }

    fun setCurrentSubject(id: Int){
        _currentSubject = _subjectRepository.findSubjectById(id)
    }

    /*
    fun findPeopleFromSubject() {
        viewModelScope.launch {
            Log.d("getPeopleFromSubject", "Odpalona")
            Log.d("getPeopleFromSubject", "${_subjectStudentsList.value?.size}")
            _subjectStudentsList.value?.forEach {
                Log.d("getPeopleFromSubject", "${it.person_id}")
                val element = _personRepository.findPersonById(it.person_id).value
                if (element != null) {
                    _mainList.value?.add(element)
                    Log.d("getPeopleFromSubject", "Znaleziono element")
                }
            }
        }
    }
    */

    fun addPerson(person :PersonModel){
        viewModelScope.launch{
            _personRepository.add(person)
        }
    }


    fun killPerson(person: PersonModel){
        viewModelScope.launch{
            _personRepository.delete(person)
        }

    }

}