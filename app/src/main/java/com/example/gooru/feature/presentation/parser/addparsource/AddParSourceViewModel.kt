package com.example.gooru.feature.presentation.parser.addparsource

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gooru.core.LoadState
import com.example.gooru.core.base.BaseViewModel
import com.example.gooru.core.dispatcher.DispatchersWrapper
import com.example.gooru.feature.domain.useCase.parsource.NewParSourceUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddParSourceViewModel(
    private val newParSourceUseCase: NewParSourceUseCase,
    private val dispatchers: DispatchersWrapper
) : BaseViewModel() {

    private val _isBackStack = MutableStateFlow(false)
    val isBackStack = _isBackStack.asStateFlow()

    fun getExchangeParsing() = createExchangeParsing()

    fun creteParSource(
        dataType: Int,
        description: String,
        freelanceSource: List<ExchangeParsing>,
        keywords: List<String>,
        name: String
    ) {
        viewModelScope.launch(dispatchers.io + handler) {
            _loadState.value = LoadState.LOADING
            newParSourceUseCase.crete(dataType, description, freelanceSource, keywords, name)
            _loadState.value = LoadState.SUCCESS
            delay(1_000)
            _isBackStack.value = true
        }
    }

}