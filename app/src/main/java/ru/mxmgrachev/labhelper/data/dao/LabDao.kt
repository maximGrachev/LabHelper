package ru.mxmgrachev.labhelper.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.mxmgrachev.labhelper.data.entity.Lab

@Dao
interface LabDao {
    @Insert
    suspend fun insert(lab: Lab)

    @Query("select * from lab")
    suspend fun getAllLab(): List<Lab>

    @Query("select distinct name from lab")
    suspend fun getAllSubject(): String

    @Query("select * from lab order by id desc limit 5")
    suspend fun getLastAddedLab(): List<Lab>
}