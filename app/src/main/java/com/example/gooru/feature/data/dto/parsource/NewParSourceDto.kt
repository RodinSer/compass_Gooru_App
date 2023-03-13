package com.example.gooru.feature.data.dto.parsource

import com.example.gooru.core.extensions.simpleDateFormat
import com.example.gooru.feature.domain.model.homepage.parsource.ParSourceHome

data class NewParSourceDto(
    val data_source: String,
    val data_type: Int,
    val description: String,
    val freelance_source: List<Int>,
    val id: Int,
    val keywords: String,
    val name: String,
    val parse_fields: Any,
    val url_detail: Any,
    val user: Int
)