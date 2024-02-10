package com.example.hw_3_4.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.hw_3_4.dataa.Converters

@Entity
@TypeConverters(Converters::class)
data class Project(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val deadlineDay: Int,
    val category: String,
    val persentage: Int ?= 0,
    val status: String,
    )
