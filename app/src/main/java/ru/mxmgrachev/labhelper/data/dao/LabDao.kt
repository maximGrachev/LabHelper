package ru.mxmgrachev.labhelper.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.mxmgrachev.labhelper.data.entity.Lab

@Dao
interface LabDao {
    @Insert
    suspend fun insert(lab: Lab)

    @Update
    suspend fun update(lab: Lab)

    @Query("select * from lab")
    fun getAllLab(): List<Lab>

    @Query("select * from lab order by id desc limit 5")
    fun getLastAddedLab(): List<Lab>
}