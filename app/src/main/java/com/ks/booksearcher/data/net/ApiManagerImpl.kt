package com.ks.booksearcher.data.net

import com.ks.booksearcher.data.net.response.ResponseMapper
import com.ks.booksearcher.data.model.Book
import com.ks.booksearcher.exception.NetworkException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManagerImpl : ApiManager {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ApiService::class.java)

    override fun getBooks(query: String, page: Int): List<Book> {
        val response = service.getBooksAsync(query, page = page).execute()
        if (!response.isSuccessful)
            throw NetworkException("network failure")

        return response.body()?.documents?.map { ResponseMapper.convertToBook(it) } ?: emptyList()
    }
}