package com.example.hw_3_4

import android.app.Application
import androidx.room.Room
import com.example.hw_3_4.Data.local.Pref
import com.example.hw_3_4.dataa.TaskDatabase
import com.google.firebase.FirebaseApp

class App: Application() {

    var mySharedPreferense: Pref.MySharedPreferences? = null

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        db = TaskDatabase.getDatabase(this, allowMainThreadQueries = true)
    }

    companion object {
        lateinit var db: TaskDatabase
    }
}
