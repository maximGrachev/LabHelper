package ru.mxmgrachev.labhelper.data.dao

import androidx.room.Dao
import androidx.room.Query
import ru.mxmgrachev.labhelper.data.entity.Subject

@Dao
interface SubjectDao {
    @Query("select * from subject")
    fun getAllSubject(): List<Subject>
}