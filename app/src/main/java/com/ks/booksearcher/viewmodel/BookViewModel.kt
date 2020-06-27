package com.ks.booksearcher.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ks.booksearcher.data.repository.BookRepository
import com.ks.booksearcher.data.repository.BookRepositoryImpl

class BookViewModel : ViewModel() {

    private val repository: BookRepository = BookRepositoryImpl()
    private val keyword: MutableLiveData<String> = MutableLiveData()
    private val list = Transformations.map(keyword) { repository.getBooks(it) }

    val result = Transformations.switchMap(list) { it }

    fun search(keyword: String): Boolean {
        if (this.keyword.value == keyword)
            return false

        this.keyword.value = keyword
        return true
    }

    fun getKeyword(): String? = keyword.value
}