package com.example.ioasys.sections.home.fragments.list

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasys.sections.util.getStringPreferences
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListViewModel(
    private val context: Context,
    private val view: ListInterface,
    private val listDataSource: ListDataSource
): ViewModel() {

    private fun getTripleQuery(): Triple<String, String, String> {
        val client = context.getStringPreferences("client")
        val token = context.getStringPreferences("token")
        val uid = context.getStringPreferences("uid")
        return Triple(client, token, uid)
    }

    fun getList(enterprise: String) {
        viewModelScope.launch {
            view.showLoading()
            val list = listDataSource.getList(enterprise, getTripleQuery())
            list.collect {
                if (!it.isNullOrEmpty()) view.updateList(it)
                else view.showEmptyList()
            }
            view.hideLoading()
        }
    }

    fun getEnterprise(id: Int) {
        viewModelScope.launch {
            view.showLoading()
            val enterprise = listDataSource.getEnterprise(id, getTripleQuery())
            enterprise.collect {
                if (it != null) view.goToDetailEnterprise(it)
                else view.showGenericError()
            }
            view.hideLoading()
        }
    }
}