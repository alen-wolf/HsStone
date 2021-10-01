package com.example.hstone.startFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hstone.R
import com.example.hstone.databinding.FragmentHomeBinding

class Home : Fragment(R.layout.fragment_home) {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding=binding

        binding.button.setOnClickListener {
            val action = HomeDirections.actionHomeToClassSelect()
            findNavController().navigate(action)
        }

    }

}