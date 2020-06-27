package com.ks.booksearcher.data.net.response

import com.google.gson.annotations.SerializedName

class ApiResponse {

    @SerializedName("meta")
    var meta: Meta? = null

    @SerializedName("documents")
    var documents: List<Document>? = null

    class Meta {
        @SerializedName("is_end")
        var isIsEnd = false

        @SerializedName("pageable_count")
        var pageableCount = 0

        @SerializedName("total_count")
        var totalCount = 0
    }

    class Document {
        @SerializedName("authors")
        var authors: List<String>? = null

        @SerializedName("contents")
        var contents: String? = null

        @SerializedName("datetime")
        var datetime: String? = null

        @SerializedName("isbn")
        var isbn: String? = null

        @SerializedName("price")
        var price = 0

        @SerializedName("publisher")
        var publisher: String? = null

        @SerializedName("sale_price")
        var salePrice = 0

        @SerializedName("status")
        var status: String? = null

        @SerializedName("thumbnail")
        var thumbnail: String? = null

        @SerializedName("title")
        var title: String? = null

        @SerializedName("translators")
        var translators: List<String>? = null

        @SerializedName("url")
        var url: String? = null
    }
}