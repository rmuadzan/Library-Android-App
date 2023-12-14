package com.D121211052.libraryapp.ui.activites.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211052.libraryapp.MyApplication
import com.D121211052.libraryapp.data.models.Book
import com.D121211052.libraryapp.data.repository.BooksRepositories
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val books: List<Book>): MainUiState
    object Error: MainUiState
    object Loading: MainUiState
}

class MainViewModel(private val booksRepositories: BooksRepositories): ViewModel() {
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getBooks() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val res = booksRepositories.getBooks()
            Log.d("dadsa", "${res.items?.mapNotNull { it?.volumeInfo }}")
            mainUiState = MainUiState.Success(res.items?.mapNotNull { it?.volumeInfo } ?: emptyList())
        } catch (e: IOException) {
            mainUiState =MainUiState.Error
        }
    }

    init {
        getBooks()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val booksRepositories = application.containter.booksRepositories
                MainViewModel(booksRepositories)
            }
        }
    }
}