package com.itsz.data.net.dto

import com.itsz.model.Girl

data class GirlJson(
    val `data`: List<DataJson>?,
    val page: Int?,
    val page_count: Int?,
    val status: Int?,
    val total_counts: Int?
)

data class DataJson(
    val _id: String?,
    val author: String?,
    val category: String?,
    val createdAt: String?,
    val desc: String?,
    val images: List<String>?,
    val likeCounts: Int?,
    val publishedAt: String?,
    val stars: Int?,
    val title: String?,
    val type: String?,
    val url: String?,
    val views: Int?
)

internal fun GirlJson.toDomainModel() = run { Girl(avatar = this.data?.get(0)?.url.toString()) }