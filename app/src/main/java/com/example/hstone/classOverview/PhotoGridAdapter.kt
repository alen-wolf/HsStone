package com.example.hstone.classOverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hstone.databinding.GridViewItemBinding
import com.example.hstone.network.CardProperty

class PhotoGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<CardProperty,
        PhotoGridAdapter.CardPropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.CardPropertyViewHolder {
        return CardPropertyViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.CardPropertyViewHolder, position: Int) {
        val cardProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(cardProperty)
        }
        holder.bind(cardProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CardProperty>() {
        override fun areItemsTheSame(oldItem: CardProperty, newItem: CardProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CardProperty, newItem: CardProperty): Boolean {
            return oldItem.name == newItem.name
        }

    }

    class CardPropertyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cardProperty: CardProperty) {
            binding.property = cardProperty
            binding.executePendingBindings()
        }

    }

    class OnClickListener(val clickListener: (cardProperty: CardProperty) -> Unit) {
        fun onClick(cardProperty: CardProperty) = clickListener(cardProperty)
    }


}