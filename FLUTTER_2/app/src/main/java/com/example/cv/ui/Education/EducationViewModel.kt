package com.example.cv.ui.Education

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EducationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is EDUCATION Fragment"
    }
    val text: LiveData<String> = _text
}