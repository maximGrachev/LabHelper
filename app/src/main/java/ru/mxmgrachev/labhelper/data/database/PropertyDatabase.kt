package ru.mxmgrachev.labhelper.data.database

import androidx.room.Database
import ru.mxmgrachev.labhelper.data.entity.Property

@Database(entities = [Property::class], version = 1)
class PropertyDatabase {
}