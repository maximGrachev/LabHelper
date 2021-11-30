package ru.mxmgrachev.labhelper.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mxmgrachev.labhelper.data.dao.SubjectDao
import ru.mxmgrachev.labhelper.data.entity.Subject

@Database(entities = [Subject::class], version = 1)
abstract class SubjectDatabase: RoomDatabase() {
    abstract fun subjectDao(): SubjectDao
}