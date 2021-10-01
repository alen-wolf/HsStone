package com.example.hstone.startFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hstone.R
import com.example.hstone.databinding.FragmentClassSelectBinding

class classSelect : Fragment(R.layout.fragment_class_select) {

    private lateinit var fragmentClassSelectBinding: FragmentClassSelectBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClassSelectBinding.bind(view)
        fragmentClassSelectBinding=binding


        binding.imageButtonWarrior.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToClassFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonPaladin.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToPalladinFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonHunter.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToHunterFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonRogue.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToRogueFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonShaman.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToShamanFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonMage.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToMageFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonPriest.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToPriestFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonWarlock.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToWarlockFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonDruid.setOnClickListener {
            val action= classSelectDirections.actionClassSelectToDruidFragment()
            findNavController().navigate(action)
        }

        binding.imageButtonDemonHunter.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToDemonHunterFragment()
            findNavController().navigate(action)
        }

        binding.floatingActionButton.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToFavouriteCards()
            findNavController().navigate(action)
        }


    }

}