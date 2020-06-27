package com.ks.booksearcher

import com.ks.booksearcher.data.model.Book
import com.ks.booksearcher.data.model.BookRequest
import com.ks.booksearcher.data.net.ApiManager
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class BookSearcherTest {

    @Test
    fun test_api() {
        val request = BookRequest("kotlin")
        val api: ApiManager = MockApi()
        //val api: ApiManager = ApiManagerImpl()

        val list = api.getBooks(request.query, 1)
        assertNotNull(list)
        assertTrue(list.isNotEmpty())
    }

    class MockApi : ApiManager {
        override fun getBooks(query: String, page: Int): List<Book> {
            return arrayListOf(Book("title", "publisher", "thumbnail", "contents", "url"))
        }
    }
}