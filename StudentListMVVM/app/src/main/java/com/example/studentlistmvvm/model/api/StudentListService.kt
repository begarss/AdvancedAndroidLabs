package com.example.studentlistmvvm.model.api

import com.example.studentlistmvvm.model.dataClass.Student
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentListService {
    @GET("students")
    fun getStudents():Single<ArrayList<Student>>

    @GET("students/{id}")
    fun getStudentDetails(@Path("id") id:Int):Single<Student>
}