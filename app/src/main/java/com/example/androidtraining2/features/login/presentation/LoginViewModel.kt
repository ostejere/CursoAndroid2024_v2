package com.example.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.example.androidtraining2.features.login.domain.SignInUseCase

class LoginViewModel(
    private val singInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel () {

    fun validateClicked(username: String, password: String, isRememberChecked: Boolean): Boolean {
        if (isRememberChecked) {
            saveUsernameUseCase.invoke(username)
        }
        return singInUseCase.invoke(username, password)
    }

}