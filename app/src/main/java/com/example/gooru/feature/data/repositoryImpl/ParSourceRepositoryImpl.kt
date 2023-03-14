package com.example.gooru.feature.data.repositoryImpl

import com.example.gooru.feature.data.api.ParSourceApi
import com.example.gooru.feature.data.body.BodyParSource
import com.example.gooru.feature.domain.model.homepage.parsource.PopularParSource
import com.example.gooru.feature.domain.repository.ParSourceRepository

class ParSourceRepositoryImpl(
    private val api: ParSourceApi,
    private val popular: List<String>,
) : ParSourceRepository {

    override suspend fun getMyParsingTask() =
        api.getUserParSource().map { it.toParSourceHome() }

    override suspend fun getPopularParsingGroup() = popular.map { PopularParSource(it) }

    override suspend fun createNewParSource(body: BodyParSource) {
            api.createParSource(body)
    }


}