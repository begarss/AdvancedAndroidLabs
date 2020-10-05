package com.example.studentlistmvvm.di

import com.example.studentlistmvvm.model.api.API
import com.example.studentlistmvvm.model.api.StudentListService
import com.example.studentlistmvvm.model.repository.RepoListRepository
import com.example.studentlistmvvm.viewmodel.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module{
    single<StudentListService> { API.generateStudentService() }
}

val repoModule = module{
    single { RepoListRepository(get()) }
}

val viewModelModule = module {
    viewModel { RepoListViewModel() }
}