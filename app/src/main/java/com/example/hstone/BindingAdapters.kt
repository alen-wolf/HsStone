package com.example.hstone

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hstone.classOverview.PhotoGridAdapter
import com.example.hstone.network.CardProperty

@BindingAdapter("imgUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let{
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.empty_card)
            )
            .into(imgView)
    }

}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                    data: List<CardProperty>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}