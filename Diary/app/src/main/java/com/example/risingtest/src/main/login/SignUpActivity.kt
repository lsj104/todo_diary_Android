package com.example.risingtest.src.main.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signupBtnContinue.setOnClickListener{
            val id = binding.signupEdtId.text.toString()
            val pw = binding.signupEdtPw.text.toString()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            val sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("id", id)
            editor.putString("pw", pw)
            editor.apply()
        }
    }
}