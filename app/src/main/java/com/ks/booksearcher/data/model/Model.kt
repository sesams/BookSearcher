package com.ks.booksearcher.data.model

data class Book(
    val title: String,
    val publisher: String,
    val thumbnail: String,
    val contents: String,
    val url: String
) {
    override fun toString(): String {
        return "$title, $publisher, $thumbnail, $contents"
    }
}

data class BookRequest(val query: String)