package ru.mxmgrachev.labhelper.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property")
data class Property(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="number") val number: Int,
    @ColumnInfo(name="question") val question: String?,
    @ColumnInfo(name="status") val status: String,
    @ColumnInfo(name="lab_text") val labText: String?,
)