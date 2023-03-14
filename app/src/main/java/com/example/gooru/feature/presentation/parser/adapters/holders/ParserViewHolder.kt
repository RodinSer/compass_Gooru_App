package com.example.gooru.feature.presentation.parser.adapters.holders

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.gooru.core.ParserButton
import com.example.gooru.databinding.ItemParserBinding
import com.example.gooru.feature.domain.model.parser.Parser

class ParserViewHolder(
    private val binding: ItemParserBinding,
    private val onClickListener: (button: ParserButton) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var parser: Parser? = null

    init {

        onClickButton(binding.favoriteButton, ParserButton.FAVORITE)
        onClickButton(binding.shareButton, ParserButton.SHARE)
        onClickButton(binding.editButton, ParserButton.EDIT)
        onClickButton(binding.downloadButton, ParserButton.DOWNLOAD)
        onClickButton(binding.linkButton, ParserButton.LINK)

        clickDescription()

        clickCommentButton()

    }

    fun bind(item: Parser) {
        parser = item
        binding.title.text = item.title
        binding.comment.setText(item.article)
        binding.description.text = item.article
    }

    private fun clickCommentButton() =
        binding.commentButton.setOnClickListener {
            binding.comment.isVisible = !binding.comment.isVisible
        }

    private fun onClickButton(view: View, button: ParserButton) = view.setOnClickListener {
        button.item = parser
        onClickListener(button)
    }


    private fun clickDescription() =
        binding.description.setOnClickListener {
            binding.description.maxLines = if (binding.description.maxLines == 3)
                Int.MAX_VALUE else 3
        }

}