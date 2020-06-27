package com.ks.booksearcher.data.net.response

import com.ks.booksearcher.data.model.Book

object ResponseMapper {

    fun convertToBook(document: ApiResponse.Document): Book {
        return Book(
            document.title!!,
            document.publisher!!,
            document.thumbnail!!,
            document.contents!!,
            document.url!!
        )
    }
}