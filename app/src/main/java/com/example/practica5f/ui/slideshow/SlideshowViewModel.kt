package com.example.practica5f.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Desarrollado por su gran colaborador Connor Urbano Mendoza y Denisse Marquez Morales."
    }
    val text: LiveData<String> = _text
}