package com.creativeitinstitute.ecomplatzi2402.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.ecomplatzi2402.R
import com.creativeitinstitute.ecomplatzi2402.base.BaseFragment
import com.creativeitinstitute.ecomplatzi2402.data.models.register.RequestRegistration
import com.creativeitinstitute.ecomplatzi2402.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registrationResponse.observe(viewLifecycleOwner){
            if (it.isSuccessful){

                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }



        binding.btnRegister.setOnClickListener {

            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val imageAvatar =
                "https://media.licdn.com/dms/image/v2/D4D03AQF1wUyFUTLSxA/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1720430643854?e=2147483647&v=beta&t=5-q_n518GvsdcJfmD5IMv8wqpqkdJNjCmgWOxs80X44"


            val registerRequest = RequestRegistration(
                avatar = imageAvatar,
                name = name,
                email = email,
                password = password
            )
            viewModel.registration(registerRequest)


        }
    }


}