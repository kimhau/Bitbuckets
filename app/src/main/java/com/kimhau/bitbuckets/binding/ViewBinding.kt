package com.kimhau.bitbuckets.binding

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.kimhau.bitbuckets.ui.main.MainViewModel
import com.skydoves.whatif.whatIfNotNullOrEmpty
import java.text.SimpleDateFormat

object ViewBinding {

    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: View, text: String?) {
        text.whatIfNotNullOrEmpty {
            Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("paletteImage", "paletteCard")
    fun bindLoadImagePalette(view: AppCompatImageView, url: String, paletteCard: MaterialCardView) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("createdOn")
    fun bindCreatedOn(view: TextView, date: String) {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd MMM yyyy HH:mm")
        val output: String = formatter.format(parser.parse(date))
        view.text = "created at: $output"
    }

    @JvmStatic
    @BindingAdapter("gone")
    fun bindGone(view: View, shouldBeGone: Boolean) {
        view.visibility = if (shouldBeGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("onPressed", "viewModel")
    fun bindOnPressed(view: View, next:String?, vm: MainViewModel) {
        view.setOnClickListener{
            vm.fetchNextBitbucketList()
        }
    }

    @JvmStatic
    @BindingAdapter("onBackPressed")
    fun bindOnBackPressed(view: View, onBackPress: Boolean) {
        val context = view.context
        if (onBackPress && context is OnBackPressedDispatcherOwner) {
            view.setOnClickListener {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}