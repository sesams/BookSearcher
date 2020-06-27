package com.ks.booksearcher.data.page

import androidx.paging.DataSource
import com.ks.booksearcher.data.net.ApiManager
import com.ks.booksearcher.data.model.Book
import com.ks.booksearcher.data.model.BookRequest

class BookDataSourceFactory(
    private val api: ApiManager,
    private val request: BookRequest
) : DataSource.Factory<Int, Book>() {

    override fun create(): DataSource<Int, Book> {
        return BookDataSource(api, request)
    }
}