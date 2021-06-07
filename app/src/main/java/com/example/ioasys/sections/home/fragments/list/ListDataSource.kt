package com.example.ioasys.sections.home.fragments.list

import com.example.ioasys.models.Enterprise
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListDataSource(
    private val dataProvider: ListDataProvider,
) {
    fun getList(enterprise: String, triple: Triple<String, String, String>): Flow<List<Enterprise>?> = flow {
        val response = dataProvider.getList(enterprise, triple.first, triple.second, triple.third)
        emit(response?.enterprises)
    }

    fun getEnterprise(id: Int, triple: Triple<String, String, String>): Flow<Enterprise?> = flow {
        val response = dataProvider.getEnterprise(id, triple.first, triple.second, triple.third)
        emit(response?.enterprise)
    }
}