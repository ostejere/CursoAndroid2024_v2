package com.example.androidtraining2.features.login

import android.content.Context
import com.example.androidtraining2.features.login.data.LoginDataRepository
import com.example.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.example.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.example.androidtraining2.features.login.domain.LoginRepository
import com.example.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.example.androidtraining2.features.login.domain.SignInUseCase
import com.example.androidtraining2.features.login.presentation.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class LoginFactory (private val context: Context) {

    private val loginMockRemoteDataSource : LoginMockRemoteDataSource = provideLoginRemoteDataSource()
    private val loginXmlLocalDataSource : LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()
    private val loginRepository : LoginRepository = provideLoginDataRepository()
    private val signInUseCase : SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase : SaveUsernameUseCase = provideSaveUsernameUseCase()

    fun provideLoginViewModel() : LoginViewModel {
       return LoginViewModel(signInUseCase, saveUsernameUseCase)
    }

    private fun provideLoginRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase {
        return SaveUsernameUseCase(loginRepository)
    }

}