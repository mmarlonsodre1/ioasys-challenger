package com.example.ioasys.sections.home

import android.content.Context
import com.example.ioasys.sections.util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomePresenter(
        private val context: Context,
        private val coroutineScope: CoroutineScope,
        private val view: HomeInterface,
        private val dataProvider: HomeDataProvider
) {

    fun getList(enterprise: String) {
        coroutineScope.launch {
            view.showLoading()
            val token = context.getString("token")
            val client = context.getString("client")
            val uid = context.getString("uid")
            val list = dataProvider.getList(enterprise, client, token, uid)
            list?.enterprises?.let { view.updateList(it) } ?: view.showEmptyList()
            view.hideLoading()
        }
    }
}