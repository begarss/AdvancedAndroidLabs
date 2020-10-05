package com.example.studentlistmvvm.model.repository

import android.util.Log
import com.example.studentlistmvvm.model.api.API
import com.example.studentlistmvvm.model.api.StudentListService
import com.example.studentlistmvvm.model.dataClass.Student
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoListRepository(private val apiService: StudentListService) {
    fun getStudents(onResult: (isSuccess: Boolean, response: List<Student>?) -> Unit) {
        val students = apiService.getStudents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ students ->
                onResult(true, students)
                Log.i("MG", "success")

            }, {
                it.printStackTrace()
                onResult(false, null)
                Log.i("MG", it.message)

            })
    }

    fun getStudent(id:Int,onResult: (isSuccess: Boolean, response: Student?) -> Unit) {
        val students = apiService.getStudentDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ student ->
                onResult(true, student)
                Log.i("MG", "success")

            }, {
                it.printStackTrace()
                onResult(false, null)
                Log.i("MG", it.message)

            })
    }


}