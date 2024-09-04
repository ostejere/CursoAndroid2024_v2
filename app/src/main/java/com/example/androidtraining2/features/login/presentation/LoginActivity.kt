package com.example.androidtraining2.features.login.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtraining2.R
import com.example.androidtraining2.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory : LoginFactory
    private lateinit var loginViewModel : LoginViewModel

    // lateinit permite crear una variable e inicializarla mas tarde
    // kotlin en principio exige que todas las variables se inicialicen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
            val username = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val isValid = loginViewModel.validateClicked(username, password)

            val msg = when (isValid) {
                true -> getString(R.string.message_login_ok)
                false -> getString(R.string.message_login_fail)
            }

            Snackbar.make(
                findViewById(R.id.main),
                msg,
                Snackbar.LENGTH_SHORT
            ).show()

        }
    }
}