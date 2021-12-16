package ru.mxmgrachev.labhelper.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mxmgrachev.labhelper.data.dao.LabDao

class MainViewModel(dataSource: LabDao): ViewModel(){

    private val database = dataSource
    val labList = database.getAllLab()

    private val _navigateToLab = MutableLiveData<Int>()
    val navigateToLab
        get() = _navigateToLab

    fun onLabClicked(id: Int) {
        _navigateToLab.value = id
    }

    fun onLabFragmentNavigated() {
        _navigateToLab.value = null
    }
}