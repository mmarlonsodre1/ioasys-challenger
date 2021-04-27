package com.example.ioasys.sections.login

import com.example.ioasys.sections.util.BaseInterface

interface LoginInterface: BaseInterface {
    fun showIncorrectAccount()
    fun showGenericError()
    fun goToHomeScreen()
}