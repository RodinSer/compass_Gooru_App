package com.example.gooru.feature.presentation.chat.tikets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.gooru.databinding.ItemTicketBinding
import com.example.gooru.feature.domain.model.support.SupportTicket

class TicketsPagerAdapter(private val onClick: (id: Int) -> Unit) :
    PagingDataAdapter<SupportTicket, TicketVewHolder>(SupportTicketDiff()) {

    override fun onBindViewHolder(holder: TicketVewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TicketVewHolder(
        ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick
    )
}

