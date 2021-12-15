package ru.mxmgrachev.labhelper.ui.lab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.coroutines.launch
import ru.mxmgrachev.labhelper.data.dao.LabDao
import ru.mxmgrachev.labhelper.data.entity.Lab

class LabViewModel(
    labKey: Int,
    private val dataSource: LabDao
) : ViewModel() {
    private val database = dataSource

    fun createNewLab(
        name: String,
        number: Int?,
        question: String?,
        status: String,
        labText: String?,
    ){
        viewModelScope.launch {
            val newLab = Lab(
                id=5,
                name = name,
                number = number,
                question = question,
                status = status,
                labText = labText
            )
            insert(newLab)
        }
    }
    private suspend fun insert(lab: Lab){
        database.insert(lab)
    }
}