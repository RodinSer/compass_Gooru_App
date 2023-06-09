package com.example.gooru.feature.domain.useCase.support

import com.example.gooru.feature.domain.model.support.SupportTicket

interface SupportAllTicketsUseCase {

    suspend fun getAllTickets(page: Int): List<SupportTicket>
}