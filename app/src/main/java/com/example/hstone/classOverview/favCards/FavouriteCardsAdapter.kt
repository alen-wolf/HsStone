package com.example.hstone.classOverview.favCards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hstone.R
import com.example.hstone.favRoomDatabase.FavCard
import kotlinx.android.synthetic.main.card_row.view.*

class FavouriteCardsAdapter(private val allcards:List<FavCard>):RecyclerView.Adapter<FavouriteCardsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.name.text = allcards[position].name
        holder.itemView.card_set.text = allcards[position].cardSet
        holder.itemView.card_type.text= allcards[position].type
    }

    override fun getItemCount()= allcards.size

    class ViewHolder (view: View):RecyclerView.ViewHolder(view)
}