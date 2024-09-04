package com.example.androidtraining2.features.login.domain

class SignInUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(username: String, password: String): Boolean {
        return loginRepository.isValid(username, password)
    }

}