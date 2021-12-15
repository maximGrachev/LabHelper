package ru.mxmgrachev.labhelper.ui.lab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mxmgrachev.labhelper.data.dao.LabDao

class LabViewModelFactory(
    private val labKey: Int,
    private val dataSource: LabDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LabViewModel::class.java)) {
            return LabViewModel(labKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}