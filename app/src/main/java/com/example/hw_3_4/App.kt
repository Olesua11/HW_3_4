package com.example.hw_3_4

import TaskDatabase
import android.app.Application
import androidx.room.Room

class App: Application() {
    private lateinit var db: TaskDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var db:TaskDatabase
    }
}

