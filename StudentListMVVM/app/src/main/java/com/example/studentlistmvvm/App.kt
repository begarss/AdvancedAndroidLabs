package com.example.studentlistmvvm

import android.app.Application
import com.example.studentlistmvvm.di.networkModule
import com.example.studentlistmvvm.di.repoModule
import com.example.studentlistmvvm.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(networkModule, repoModule, viewModelModule)
        }
    }
}