package com.example.hstone.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hstone.R
import com.example.hstone.classOverview.warlock.WarlockViewModel
import com.example.hstone.databinding.FragmentDetailBinding
import com.example.hstone.favRoomDatabase.FavCard
import com.example.hstone.favRoomDatabase.FavCardDatabase
import com.example.hstone.network.CardProperty
import org.jetbrains.anko.doAsync


class DetailFragment : Fragment() {

    lateinit var cardShare:String

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private  val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)


        val card=DetailFragmentArgs.fromBundle(requireArguments()).selectedCard
        cardShare=card.name +" Type: "+card.type+" Effect: "+card.text


        val datasource =FavCardDatabase.getInstance(application).favCardDao
        val viewModelFactory = DetailViewModelFactory(card,datasource, application)

        binding.viewModel = ViewModelProvider(
            this,viewModelFactory).get(DetailViewModel::class.java)



        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share_card ->shareCard()
            R.id.fav_card ->viewModel.addCard()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun shareCard(){
        val sendIntent: Intent = Intent().apply{
            action=Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,cardShare)
            type="text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent,null)
        startActivity(shareIntent)
    }


}