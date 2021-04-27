package com.example.ioasys.sections.home

import com.example.ioasys.models.Enterprise
import com.example.ioasys.sections.util.BaseInterface

interface HomeInterface: BaseInterface {
    fun updateList(list: List<Enterprise>)
    fun showEmptyList()
}