package com.example.risingtest.src.main.write

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentWriteBinding
import com.example.risingtest.src.main.login.LoginActivity
import com.example.risingtest.src.main.news.CovidActivity
import com.kakao.sdk.user.UserApiClient

class WriteFragment: BaseFragment<FragmentWriteBinding>(FragmentWriteBinding::bind, R.layout.fragment_write) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(context, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(context, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(requireActivity(), LoginActivity::class.java)
                startActivity(intent)
            }
        }




    }
}