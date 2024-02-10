package com.example.hw_3_4.dataa

import androidx.room.TypeConverter
import com.example.hw_3_4.models.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromString(value: String): List<Task> {
        val listType = object : TypeToken<List<Task>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Task>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
