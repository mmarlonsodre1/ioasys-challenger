package com.example.ioasys.sections.home.fragments.list

import android.content.Context
import com.example.ioasys.sections.util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListPresenter(
        var context: Context? = null,
        private val coroutineScope: CoroutineScope,
        private val view: ListInterface,
        private val dataProvider: ListDataProvider
) {

    fun getList(enterprise: String) {
        coroutineScope.launch {
            view.showLoading()
            context?.let {
                val token = it.getString("token")
                val client = it.getString("client")
                val uid = it.getString("uid")
                val list = dataProvider.getList(enterprise, client, token, uid)
                list?.enterprises?.let { list -> view.updateList(list) } ?: view.showEmptyList()
            } ?: view.showGenericError()
            view.hideLoading()
        }
    }
}