package ru.mxmgrachev.labhelper.ui.lab

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mxmgrachev.labhelper.data.dao.LabDao
import ru.mxmgrachev.labhelper.data.entity.Lab

class LabViewModel(
    labKey: Int,
    dataSource: LabDao
) : ViewModel() {
    private val database = dataSource

    //TODO add and store in db random gradient

    fun createNewLab(
        name: String,
        number: Int?,
        question: String?,
        status: String,
        labText: String?,
    ) {
        val newLab = Lab(
            name = name,
            number = number,
            question = question,
            status = status,
            labText = labText
        )
        viewModelScope.launch {
            insert(newLab)
        }
    }

    private suspend fun insert(lab: Lab) {
        database.insert(lab)
    }
}