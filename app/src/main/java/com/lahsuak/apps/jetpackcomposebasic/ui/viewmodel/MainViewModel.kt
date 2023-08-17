package com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lahsuak.apps.jetpackcomposebasic.model.ImageModel
import com.lahsuak.apps.jetpackcomposebasic.network.ApiInstance
import com.lahsuak.apps.jetpackcomposebasic.util.ImagePagingSource
import com.lahsuak.apps.jetpackcomposebasic.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    private val retroService: ApiService = ApiInstance.getRetroInstance()
    private var currentSearch: String = ""

    val dataFlow =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 30,
            ),
            pagingSourceFactory = { ImagePagingSource(retroService, "") }
        ).flow.cachedIn(viewModelScope)

    fun getListData(query: String, isSearch: Boolean): Flow<PagingData<ImageModel>> {
        return Pager(config = PagingConfig(pageSize = 10, maxSize = 30),
            pagingSourceFactory = { ImagePagingSource(retroService, query) }).flow.cachedIn(
            viewModelScope
        )
    }
}
