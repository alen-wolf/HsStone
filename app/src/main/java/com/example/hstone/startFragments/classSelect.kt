package com.example.hstone.startFragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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
        val badAction = classSelectDirections.actionClassSelectToNoNetworkConnection()


        binding.imageButtonWarrior.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToClassFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonPaladin.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToPalladinFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonHunter.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToHunterFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonRogue.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToRogueFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonShaman.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToShamanFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonMage.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToMageFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonPriest.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToPriestFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonWarlock.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToWarlockFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonDruid.setOnClickListener {
            val action= classSelectDirections.actionClassSelectToDruidFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.imageButtonDemonHunter.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToDemonHunterFragment()
            if (!checkForInternet(this.requireContext())) {
                findNavController().navigate(badAction)
            }else{
                findNavController().navigate(action)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            val action = classSelectDirections.actionClassSelectToFavouriteCards()
            findNavController().navigate(action)
        }

    }

    private fun checkForInternet(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}