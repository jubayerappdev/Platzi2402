package com.creativeitinstitute.ecomplatzi2402.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.ecomplatzi2402.R
import com.creativeitinstitute.ecomplatzi2402.base.BaseFragment
import com.creativeitinstitute.ecomplatzi2402.data.models.login.RequestLogin
import com.creativeitinstitute.ecomplatzi2402.databinding.FragmentLoginBinding
import com.creativeitinstitute.ecomplatzi2402.utils.Keys
import com.creativeitinstitute.ecomplatzi2402.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel:LoginViewModel by viewModels()


    @Inject
    lateinit var prefManager: PrefManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner){


            if (it.isSuccessful){
                prefManager.setPref(Keys.ACCESS_TOKEN, it.body()?.accessToken!!)
                prefManager.setPref(Keys.REFRESH_TOKEN, it.body()?.refreshToken!!)

                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            }
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

//            handleLogin("john@mail.com","changeme")
            handleLogin("jubayer@gmail.com","123456")
//            handleLogin(email,password)
        }

    }

    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)
        viewModel.login(requestLogin)

    }

}