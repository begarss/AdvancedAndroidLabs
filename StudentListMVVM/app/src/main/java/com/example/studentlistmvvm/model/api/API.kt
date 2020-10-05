package com.example.studentlistmvvm.model.api

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object API {

    val studentListService: StudentListService =
        generateStudentService()

    fun generateStudentService(): StudentListService {
        Log.i("MG", "generatePostsService")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/sough/students/")
            .client(getHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        return retrofit.create(StudentListService::class.java)
    }

    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}