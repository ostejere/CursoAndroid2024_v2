package com.example.androidtraining2.features.login.domain

interface LoginRepository {

    fun isValid(username: String, password: String): Boolean

    fun saveUsername(username: String)

    fun deleteUsername()

    fun getUsername(): String?

}