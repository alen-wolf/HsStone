package com.example.hstone.classOverview.priest

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hstone.R
import com.example.hstone.classOverview.PhotoGridAdapter
import com.example.hstone.databinding.FragmentPriestBinding
import com.example.hstone.network.CardApiFilter
import com.example.hstone.startFragments.classSelectDirections

class PriestFragment : Fragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private  val viewModel: PriestViewModel by lazy {
        ViewModelProvider(this).get(PriestViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentPriestBinding.inflate(inflater)

        binding.lifecycleOwner=this

        binding.priestViewModel= viewModel

        setHasOptionsMenu(true)

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.displayCardDetails(it)
        })

        viewModel.navigateToSelectedCard.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    PriestFragmentDirections.actionPriestFragmentToDetailFragment(it)
                )
                viewModel.displayCardDetailsComplete()
            }
        })

        binding.floatingActionButton.setOnClickListener {
            val action = PriestFragmentDirections.actionPriestFragmentToFavouriteCards()
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