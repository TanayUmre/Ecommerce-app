package com.example.giftkart.fragments.loginRegister

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.giftkart.viewmodel.RegisterViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.giftkart.R
import com.example.giftkart.data.User
import com.example.giftkart.databinding.FragmentRegisterBinding
import com.example.giftkart.util.RegisterValidation
import com.example.giftkart.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
private val TAG="RegisterFragment"
@AndroidEntryPoint
class RegisterFragment: Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAlreadyLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.apply {
            buttonRegisterRegister.setOnClickListener {
                val user = User(
                    edFirstNameRegister.text.toString().trim(),
                    edLastNameRegister.text.toString().trim(),
                    edEmailRegister.text.toString().trim()

                )
                val password = edPasswordRegister.text.toString()
                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }
        lifecycleScope.launch{
            viewModel.register.collect{
                when(it){
                    is Resource.Loading->{
                        binding.buttonRegisterRegister.startAnimation()
                    }
                    is Resource.Success->{
                        Log.d("test",it.data.toString())
                        binding.buttonRegisterRegister.revertAnimation()
                    }
                    is Resource.Error->{
                        Log.e(TAG,it.message.toString())
                        binding.buttonRegisterRegister.revertAnimation()
                    }
                    else -> Unit
                }
            }
        }
        lifecycleScope.launch {
            viewModel.validation.collect { validation ->
                if (validation.email is RegisterValidation.Failed) {
                    with(binding.edEmailRegister) {
                        requestFocus()
                        error = validation.email.message
                    }
                }
                if (validation.password is RegisterValidation.Failed) {
                    with(binding.edPasswordRegister) {
                        requestFocus()
                        error = validation.password.message
                    }
                }
            }
        }
    }
}