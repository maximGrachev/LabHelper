package ru.mxmgrachev.labhelper.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.mxmgrachev.labhelper.data.dao.LabDao
import ru.mxmgrachev.labhelper.data.entity.Lab

@Database(entities = [Lab::class], version = 1, exportSchema = false)
abstract class LabDatabase: RoomDatabase(){
    abstract val labDao: LabDao

    companion object {

        @Volatile
        private var INSTANCE: LabDatabase ? = null

        fun getInstance(context: Context): LabDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LabDatabase::class.java,
                        "lab_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}