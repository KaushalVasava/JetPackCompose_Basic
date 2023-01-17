package com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.repo.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _newsFlow: MutableStateFlow<List<News>> = MutableStateFlow(emptyList())
    val newsFlow: StateFlow<List<News>>
        get() = _newsFlow

    private val newsRepo: NewsRepository by lazy {
        NewsRepository()
    }

    fun getNews(category: String) {
        viewModelScope.launch {
            val newsParentModel = newsRepo.getNews(category)
            _newsFlow.value = newsParentModel.articles
        }
    }
}
