package com.mikirinkode.firebasesimplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.mikirinkode.firebasesimplelogin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnRegister.setOnClickListener {
                val email = edtEmail.text.toString().trim()
                val password = edtPw.text.toString().trim()
                val passwordConf = edtPwConf.text.toString().trim()

                val isValid = checkInputValidation(email, password, passwordConf)

                // TODO: Register Logic
                if (isValid) {

                }
            }

            btnToLogin.setOnClickListener {
                // move to login activity
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun checkInputValidation(
        email: String,
        password: String,
        passwordConf: String
    ): Boolean {
        binding.apply {
            var isValid = true

            if (email.isEmpty()) {
                edtEmail.error = getString(R.string.empty_email)
                isValid = false
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.error = getString(R.string.invalid_email)
                isValid = false
            }

            if (password.isEmpty()) {
                edtPw.error = getString(R.string.empty_password)
                isValid = false
            } else if (password.length < 8) {
                edtPw.error = getString(R.string.password_too_short)
                isValid = false
            }

            if (passwordConf != password) {
                edtPwConf.error = getString(R.string.pass_not_match)
                isValid = false
            }

            return isValid
        }
    }

}