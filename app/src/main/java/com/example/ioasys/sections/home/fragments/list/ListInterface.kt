package com.example.ioasys.sections.home.fragments.list

import com.example.ioasys.models.Enterprise
import com.example.ioasys.sections.util.BaseInterface

interface ListInterface: BaseInterface {
    fun updateList(list: List<Enterprise>)
    fun showEmptyList()
}