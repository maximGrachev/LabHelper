package ru.mxmgrachev.labhelper.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lab")
data class Lab(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="name") val name: String = "",
    @ColumnInfo(name="number") val number: Int?= null,
    @ColumnInfo(name="question") val question: String? = null,
    @ColumnInfo(name="status") val status: String = "Не выполнена",
    @ColumnInfo(name="lab_text") val labText: String? = null,
)