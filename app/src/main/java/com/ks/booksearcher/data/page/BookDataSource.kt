package com.ks.booksearcher.data.page

import androidx.paging.PageKeyedDataSource
import com.ks.booksearcher.data.model.Book
import com.ks.booksearcher.data.model.BookRequest
import com.ks.booksearcher.data.net.ApiManager

class BookDataSource(
    private val api: ApiManager,
    private val request: BookRequest
) : PageKeyedDataSource<Int, Book>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Book>
    ) {
        val items = api.getBooks(request.query, 1)
        callback.onResult(items, null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Book>) {
        val items = api.getBooks(request.query, params.key)
        callback.onResult(items, params.key.inc())
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Book>) {
        val items = api.getBooks(request.query, params.key)
        callback.onResult(items, params.key.dec())
    }
}