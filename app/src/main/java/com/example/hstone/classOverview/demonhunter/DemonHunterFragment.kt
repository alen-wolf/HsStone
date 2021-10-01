package com.example.hstone.classOverview.demonhunter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hstone.R
import com.example.hstone.classOverview.PhotoGridAdapter
import com.example.hstone.databinding.FragmentDemonHunterBinding
import com.example.hstone.network.CardApiFilter
import com.example.hstone.startFragments.classSelectDirections

class DemonHunterFragment : Fragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private  val viewModel: DemonHunterViewModel by lazy {
        ViewModelProvider(this).get(DemonHunterViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentDemonHunterBinding.inflate(inflater)

        binding.lifecycleOwner=this

        binding.demonhunterViewModel= viewModel

        setHasOptionsMenu(true)

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.displayCardDetails(it)
        })

        viewModel.navigateToSelectedCard.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    DemonHunterFragmentDirections.actionDemonHunterFragmentToDetailFragment(it)
                )
                viewModel.displayCardDetailsComplete()
            }
        })

        binding.floatingActionButton.setOnClickListener {
            val action = DemonHunterFragmentDirections.actionDemonHunterFragmentToFavouriteCards()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when(item.itemId){
                R.id.item1 -> CardApiFilter.SHOW_ALL
                R.id.item2 -> CardApiFilter.SHOW_COLLECTIBLE
                else -> CardApiFilter.SHOW_ALL
            }
        )
        return true
    }
}