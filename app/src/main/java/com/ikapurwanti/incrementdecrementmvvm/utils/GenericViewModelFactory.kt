package com.ikapurwanti.incrementdecrementmvvm.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object GenericViewModelFactory {
    @Suppress("UNCHECKED_CAST")
    fun create(vm : ViewModel) = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = vm as T
    }
}