package com.example.hstone.classOverview.favCards

import android.os.Bundle
import android.view.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hstone.R
import com.example.hstone.databinding.FragmentDetailBinding
import com.example.hstone.databinding.FragmentFavouriteCardsBinding
import com.example.hstone.detail.DetailViewModel
import com.example.hstone.favRoomDatabase.FavCardDao
import com.example.hstone.favRoomDatabase.FavCardDatabase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavouriteCards : Fragment() {

    private lateinit var alldata:FavCardDao

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentFavouriteCardsBinding.inflate(inflater)

        setHasOptionsMenu(true)

        val application = requireNotNull(activity).application
        val dataSource=FavCardDatabase.getInstance(application).favCardDao
        alldata=dataSource

        doAsync {
            val allCards = dataSource.getAllCards()
            uiThread {
                binding.favRecycler.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter=FavouriteCardsAdapter(allCards)

                }
            }
        }


        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.clear->doAsync {
                alldata.clear()
                uiThread {
                    val action = FavouriteCardsDirections.actionFavouriteCardsSelf()
                    findNavController().navigate(action)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }


}