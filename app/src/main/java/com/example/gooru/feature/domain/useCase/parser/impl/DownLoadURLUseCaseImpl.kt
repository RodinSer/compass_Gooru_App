package com.example.gooru.feature.domain.useCase.parser.impl

import com.example.gooru.feature.domain.model.body.BodyDownloadFile
import com.example.gooru.feature.domain.repository.ParserRepository
import com.example.gooru.feature.domain.useCase.parser.DownLoadURLUseCase

class DownLoadURLUseCaseImpl(
    private val parserRepository: ParserRepository
) : DownLoadURLUseCase {

    override suspend fun getUrl(parSourceId: Int, parserId: Int?): String {
        val list = if (parserId != null)
            listOf(parserId).toString() else null
        return parserRepository.getUrlExel(
            BodyDownloadFile(parSourceId, list)
        )
    }
}