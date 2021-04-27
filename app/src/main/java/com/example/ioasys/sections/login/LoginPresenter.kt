package com.example.ioasys.sections.login

import android.content.Context
import com.example.ioasys.models.LoginRequest
import com.example.ioasys.sections.util.saveString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoginPresenter(
        private val context: Context,
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
                else {
                    user?.headers?.let {
                        context.saveString("token", it["access-token"] ?: "")
                        context.saveString("client", it["client"] ?: "")
                        context.saveString("uid", it["uid"] ?: "")
                    }
                    view.goToHomeScreen()
                }
            } catch (e: Throwable) {
                view.showGenericError()
            }
            view.hideLoading()
        }
    }
}