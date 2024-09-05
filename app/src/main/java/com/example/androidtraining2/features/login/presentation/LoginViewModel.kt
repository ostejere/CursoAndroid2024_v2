package com.example.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.example.androidtraining2.features.login.domain.GetUsernameUseCase
import com.example.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.example.androidtraining2.features.login.domain.SignInUseCase

class LoginViewModel(
    private val singInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameUseCase: DeleteUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase
) : ViewModel () {

    fun validateClicked(username: String, password: String, isRememberChecked: Boolean): Boolean {
        if (isRememberChecked) {
            saveUsernameUseCase.invoke(username)
        } else {
            deleteUsernameUseCase.invoke()
        }
        return singInUseCase.invoke(username, password)
    }

    fun onResumed (): String? {
        return getUsernameUseCase.invoke()
    }

}