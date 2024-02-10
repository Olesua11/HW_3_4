package com.example.hw_3_4.dataa

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw_3_4.models.Project
import com.example.hw_3_4.models.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTasks(): List<Task>

    @Query("SELECT * FROM task WHERE projectId = :id")
    fun getTasksByPId(id: Long): List<Task>

  /*  @Query("UPDATE project SET list=:list WHERE id = :projectId")
    fun updateProjectById(list: List<Task>, projectId: Long)*/

    @Query("UPDATE project SET persentage=:persentage WHERE id = :projectId")
    fun updateProjectPersentageById(persentage: Int, projectId: Long)

    @Query("UPDATE task SET checkBox=:checkBox WHERE id = :id")
    fun updateTaskCheckBoxById(checkBox: Boolean,id: Long)

    @Query("SELECT*FROM project")
    fun getAllProjects(): List<Project>

    @Query("SELECT*FROM project WHERE category= :category")
    fun getProjectsByCategory(category: String): List<Project>

    @Insert
    fun insertProject(project: Project)

    @Update
    fun updateProject(project: Project)

    @Delete
    fun updateDelete(project: Project)

    @Insert
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}
