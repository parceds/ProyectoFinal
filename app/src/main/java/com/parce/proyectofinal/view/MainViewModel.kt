package com.parce.proyectofinal.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.parce.proyectofinal.model.StringCompare

class MainViewModel: ViewModel() {
    private var _stringCompare = MutableLiveData<StringCompare>()
    val stringCompare: LiveData<StringCompare> get() = _stringCompare

    fun compareStrings(str1:String, str2:String){
        val compResult:Boolean = (str1 == str2)
        updateStringCompare(str1,str2,compResult)
    }

    private fun updateStringCompare(str1: String, str2: String, compResult:Boolean){
        _stringCompare.value = StringCompare(str1,str2,compResult)
    }
}