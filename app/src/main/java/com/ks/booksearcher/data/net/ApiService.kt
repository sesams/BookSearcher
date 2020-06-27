package com.ks.booksearcher.data.net

import com.ks.booksearcher.data.net.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

var BASE_URL = "https://dapi.kakao.com/"

interface ApiService {

    @Headers("Authorization: KakaoAK be1ebb2c281ff24c627ecb554a7ce961")
    @GET("/v3/search/book")
    fun getBooksAsync(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 50,
        @Query("target") target: String = "title"
    ): Call<ApiResponse>
}