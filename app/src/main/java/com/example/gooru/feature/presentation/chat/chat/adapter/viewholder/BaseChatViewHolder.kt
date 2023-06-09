package com.example.gooru.feature.presentation.chat.chat.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.gooru.feature.domain.model.ChatMessage

abstract class BaseChatViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: ChatMessage)
}