package com.example.gooru.feature.domain.useCase.parsource.impl

import com.example.gooru.feature.data.body.BodyParSource
import com.example.gooru.feature.domain.repository.ParSourceRepository
import com.example.gooru.feature.domain.useCase.parsource.NewParSourceUseCase
import com.example.gooru.feature.presentation.parser.addparsource.ExchangeParsing

class NewParSourceUseCaseImpl(
    private val parSourceRepository: ParSourceRepository
) : NewParSourceUseCase {
    override suspend fun crete(
        dataType: Int,
        description: String,
        freelanceSource: List<ExchangeParsing>,
        keywords: List<String>,
        name: String
    ) {
        val source = mutableListOf<Int>()
        freelanceSource.forEach{
            if (it.isSelected) source.add(it.id)
        }
        parSourceRepository.createNewParSource(
            BodyParSource(dataType, description, source, keywords.toString(), name)
        )
    }

}