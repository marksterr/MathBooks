package com.rave.mathbooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.mathbooks.model.MathRepo
import com.rave.mathbooks.model.local.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Math view model.
 *
 * @property repo
 * @constructor Create empty Math view model
 */
@HiltViewModel
class MathViewModel @Inject constructor(private val repo: MathRepo) : ViewModel() {
    private val _books: MutableLiveData<List<Book>> = MutableLiveData()
    val books: LiveData<List<Book>> get() = _books

    init {
        getMathBooks()
    }

    /**
     * Get math books.
     *
     */
    private fun getMathBooks() = viewModelScope.launch {
        _books.value = repo.getMathBooks()
    }
}
