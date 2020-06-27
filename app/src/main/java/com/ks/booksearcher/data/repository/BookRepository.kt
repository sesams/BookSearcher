package com.ks.booksearcher.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ks.booksearcher.data.net.ApiManagerImpl
import com.ks.booksearcher.data.model.Book
import com.ks.booksearcher.data.model.BookRequest
import com.ks.booksearcher.data.page.BookDataSourceFactory
import java.util.concurrent.Executors

interface BookRepository {
    fun getBooks(keyword: String): LiveData<PagedList<Book>>
}

class BookRepositoryImpl : BookRepository {

    companion object {
        const val PAGE_SIZE = 50
    }

    override fun getBooks(keyword: String): LiveData<PagedList<Book>> {
        val factory = BookDataSourceFactory(
            ApiManagerImpl(),
            BookRequest(keyword)
        )

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(PAGE_SIZE / 3)
            .build()

        return LivePagedListBuilder<Int, Book>(factory, pagedListConfig)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}