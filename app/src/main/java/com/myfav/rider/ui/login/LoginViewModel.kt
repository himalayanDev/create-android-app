package com.myfav.rider.ui.login

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel


class LoginViewModel(application: Application) : AndroidViewModel(application) {


    private var context: Context = application.applicationContext

    //LIVE DATA
//    private val _loginForm = MutableLiveData<LoginFormState>()
//    val loginFormState: LiveData<LoginFormState> = _loginForm
//    fun clearLoginExecutionState() {
//        _LoginExecutionState.value = ExecutionState()
//    }


    companion object {
        const val NAV_ACTION_LOGIN = 0
        const val NAV_ACTION_NEW_USER = 1
        const val NAV_ACTION_FORGOT_PASSWORD = 2
    }

    init {

    }


    fun validateLoginForm(username: String, password: String) {

    }

    private fun authenticate() {

    }


}
