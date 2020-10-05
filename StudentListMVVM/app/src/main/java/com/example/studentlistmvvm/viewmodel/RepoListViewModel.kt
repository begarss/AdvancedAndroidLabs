package com.example.studentlistmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.studentlistmvvm.model.dataClass.Student
import com.example.studentlistmvvm.model.repository.RepoListRepository
import org.koin.core.KoinComponent
import org.koin.core.inject


class RepoListViewModel : BaseViewModel(),KoinComponent {
    val repolistLive = MutableLiveData<List<Student>>()
    private val repository : RepoListRepository by inject()
    val student = MutableLiveData<Student>()
    fun fetchRepoList() {
        dataLoading.value = true
        repository.getStudents { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repolistLive.value = response
                empty.value = false
            } else
                empty.value = true

        }
    }

    fun fetchStudentDetails(id:Int){
        dataLoading.value = true
        repository.getStudent(id){
            isSuccess, response ->
            dataLoading.value = false
            if (isSuccess){
                student.value = response
                empty.value = false
            }else
                empty.value =true
        }
    }
}