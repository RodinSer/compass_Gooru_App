package com.example.gooru.feature.presentation.parsers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gooru.core.generation.ExchangeParsing
import com.example.gooru.databinding.ItemExchangeParsingBinding
import com.example.gooru.feature.presentation.parsers.adapters.holders.ExchangeViewHolder

class ExchangeAdapter : RecyclerView.Adapter<ExchangeViewHolder>() {

    private var items = listOf<ExchangeParsing>()

    fun setItems(list: List<ExchangeParsing>) {
        items = list
    }

    fun getItems() = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExchangeViewHolder(
        ItemExchangeParsingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) { position -> items[position].isSelected = !items[position].isSelected }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        holder.bind(items[position])
    }

}

