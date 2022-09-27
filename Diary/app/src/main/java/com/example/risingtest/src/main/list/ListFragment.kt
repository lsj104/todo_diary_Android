package com.example.risingtest.src.main.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentListBinding
import com.example.risingtest.src.main.news.WeatherActivity
import com.example.risingtest.src.main.write.TodoWirteActivity

class ListFragment: BaseFragment<FragmentListBinding>(FragmentListBinding::bind, R.layout.fragment_list){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btntodo.setOnClickListener {
            val intent = Intent(requireActivity(), TodoWirteActivity::class.java)
            startActivity(intent)
        }


        binding.btnweather.setOnClickListener {
            val intent = Intent(requireActivity(), WeatherActivity::class.java)
            startActivity(intent)
        }


    }
}