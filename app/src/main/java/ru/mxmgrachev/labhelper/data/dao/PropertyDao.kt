package ru.mxmgrachev.labhelper.data.dao

import androidx.room.Dao
import androidx.room.Query
import ru.mxmgrachev.labhelper.data.entity.Property

@Dao
interface PropertyDao {
    @Query("select * from property")
    fun getAllProperty(): List<Property>
}