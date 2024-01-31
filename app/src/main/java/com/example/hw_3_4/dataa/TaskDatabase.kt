package com.example.hw_3_4.dataa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hw_3_4.models.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context, allowMainThreadQueries: Boolean): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database"
                ).fallbackToDestructiveMigration()

                if (allowMainThreadQueries) {
                    builder.allowMainThreadQueries()
                }

                val instance = builder.build()

                INSTANCE = instance
                instance
            }
        }
    }
}
