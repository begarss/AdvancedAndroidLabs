package com.example.studentlistmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.studentlistmvvm.model.dataClass.Student
import com.example.studentlistmvvm.model.repository.RepoListRepository

class RepoListViewModel : BaseViewModel() {
    val repolistLive = MutableLiveData<List<Student>>()
    val student = MutableLiveData<Student>()
    fun fetchRepoList() {
        dataLoading.value = true
        RepoListRepository.getInstance().getStudents { isSuccess, response ->
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
        RepoListRepository.getInstance().getStudent(id){
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