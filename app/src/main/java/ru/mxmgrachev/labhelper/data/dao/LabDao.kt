package ru.mxmgrachev.labhelper.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.mxmgrachev.labhelper.data.entity.Lab

@Dao
interface LabDao {
    @Insert
    fun insert(lab: Lab)

    @Query("select * from lab")
    fun getAllFullLab(): List<Lab>

    @Query("select distinct name from lab")
    fun getAllSubject(): String
}