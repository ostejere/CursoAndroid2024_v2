package com.example.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtraining2.features.login.domain.SignInUseCase

class LoginViewModel(private val singInUseCase: SignInUseCase) : ViewModel () {

    fun validateClicked(username: String, password: String): Boolean {
        return singInUseCase.invoke(username, password)
    }

}