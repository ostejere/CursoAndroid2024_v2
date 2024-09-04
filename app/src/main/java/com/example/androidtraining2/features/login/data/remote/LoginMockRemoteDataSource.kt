package com.example.androidtraining2.features.login.data.remote

class LoginMockRemoteDataSource {

    private val username = "android"
    private val password = "12345"

    fun validate (username: String, password: String): Boolean {
        return ((this.username == username) && (this.password == password))
    }

}