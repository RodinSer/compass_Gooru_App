package com.example.gooru.feature.presentation.parsers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gooru.databinding.ItemParsingBinding
import com.example.gooru.feature.domain.model.homepage.parsource.ParSourceHome
import com.example.gooru.feature.presentation.parsers.adapters.holders.ParSoursViewHolder

class ParSourceAdapter (private val onClick:(parSourceId:Int)->Unit): RecyclerView.Adapter<ParSoursViewHolder>() {

    private var items = listOf<ParSourceHome>()

    fun setList(list: List<ParSourceHome>) {
        items = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ParSoursViewHolder(
        ItemParsingBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ParSoursViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

