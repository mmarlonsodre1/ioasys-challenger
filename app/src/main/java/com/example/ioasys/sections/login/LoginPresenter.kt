package com.example.ioasys.sections.login

import com.example.ioasys.models.LoginRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoginPresenter(
    private val coroutineScope: CoroutineScope,
    private val view: LoginInterface,
    private val dataProvider: LoginDataProvider
) {

    fun postLogin(email: String, password: String) {
        coroutineScope.launch {
            view.showLoading()
            try {
                val user = dataProvider.postLogin(LoginRequest(email, password))
                if (user?.success == false) view.showIncorrectAccount()
            } catch (e: Throwable) {
                view.showGenericError()
            }
            view.hideLoading()
        }
    }
}