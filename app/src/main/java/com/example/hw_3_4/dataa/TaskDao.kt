import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTasks(): List<Task>
/*
    @Query("SELECT * FROM task WHERE status = ")
    fun getDoneTasks(): List<Task>
*/

    @Insert
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}