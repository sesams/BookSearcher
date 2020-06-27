package com.ks.booksearcher.data.net

import com.ks.booksearcher.data.model.Book

interface ApiManager {
    fun getBooks(query: String, page: Int): List<Book>
}