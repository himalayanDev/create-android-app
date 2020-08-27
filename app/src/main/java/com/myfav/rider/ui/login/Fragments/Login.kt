package com.myfav.rider.ui.login.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.myfav.rider.databinding.LoginBinding
import com.myfav.rider.interfaces.NavigationHandler
import com.myfav.rider.ui.login.LoginViewModel
import com.myfav.rider.utils.UserAlertClient

class Login : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginBinding
    private lateinit var userAlertClient: UserAlertClient
    private lateinit var navigationHandler: NavigationHandler

    companion object {
        private var INSTANCE: Login? = null

        fun getInstance(): Login {
            return INSTANCE ?: Login()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHandler) {
            navigationHandler = context
        } else {
            throw RuntimeException(
                context.toString()
                        + " must implement NavigationHandler"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginBinding.inflate(layoutInflater)
        init()
        return binding.root
    }


    private fun init() {
        userAlertClient = UserAlertClient(activity)
        viewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel::class.java)

        binding.login.setOnClickListener {
            userAlertClient.showWaitDialog("Authenticating...")
            viewModel.validateLoginForm(
                binding.username.text.toString(),
                binding.password.text.toString()
            )
        }



//        viewModel.loginFormState.observe(viewLifecycleOwner, Observer {
//            val loginFormState = it ?: return@Observer
//
//
//
//        })
    }

}
