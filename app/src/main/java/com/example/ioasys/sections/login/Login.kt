package com.example.ioasys.sections.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.ioasys.R
import com.example.ioasys.sections.home.Home
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_loading.*

class Login : AppCompatActivity(), LoginInterface {
    private val presenter = LoginPresenter(this, lifecycleScope, this, LoginDataProvider())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login?.setOnClickListener {
            presenter.postLogin(edt_email?.editText?.text.toString(), edt_password?.editText?.text.toString())
        }
        edt_email?.editText?.doAfterTextChanged {
            enableButton()
            inputError(false)
        }
        edt_password?.editText?.doAfterTextChanged {
            enableButton()
            inputError(false)
        }
    }

    private fun enableButton() {
        btn_login?.isEnabled = !edt_email?.editText?.text.isNullOrEmpty() && !edt_password?.editText?.text.isNullOrEmpty()
    }

    private fun inputError(isError: Boolean) {
        if (isError) {
            edt_email?.error = " "
            edt_password?.error = " "
            tv_error?.isVisible = true
            tv_error?.isVisible = true
        } else {
            edt_email?.error = null
            edt_password?.error = null
            tv_error?.isVisible = false
        }
    }

    override fun showIncorrectAccount() {
        inputError(true)
        tv_error?.apply {
            text = getString(R.string.login_error)
        }
    }

    override fun showGenericError() {
        tv_error?.apply {
            text = getString(R.string.generic_error)
            isVisible = true
        }
    }

    override fun goToHomeScreen() {
        startActivity(
            Intent(this, Home::class.java).apply {
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
        )
        finish()
    }

    override fun showLoading() {
        loading?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading?.visibility = View.GONE
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}