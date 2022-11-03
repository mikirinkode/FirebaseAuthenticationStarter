package com.mikirinkode.firebasesimplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikirinkode.firebasesimplelogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                var isValid = true

                val email = edtEmailLogin.text.toString().trim()
                val password = edtPwLogin.text.toString().trim()

                if (email.isEmpty()) {
                    edtEmailLogin.error = getString(R.string.empty_email)
                    isValid = false
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmailLogin.error = getString(R.string.invalid_email)
                    isValid = false
                }

                if (password.isEmpty()) {
                    edtPwLogin.error = getString(R.string.empty_password)
                    isValid = false
                }

                // TODO: Login Logic
                if (isValid){

                }
            }

            btnToRegister.setOnClickListener {
                // move to register activity
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                finish()
            }
        }
    }
}