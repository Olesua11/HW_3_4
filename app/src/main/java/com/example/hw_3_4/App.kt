package com.example.hw_3_4

import android.app.Application
import androidx.room.Room
import com.example.hw_3_4.dataa.TaskDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = TaskDatabase.getDatabase(this, allowMainThreadQueries = true)
    }

    companion object {
        lateinit var db: TaskDatabase
    }
}
