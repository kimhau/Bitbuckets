package com.kimhau.bitbuckets.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kimhau.bitbuckets.R
import com.kimhau.bitbuckets.databinding.ItemBitbucketBinding
import com.kimhau.bitbuckets.model.Bitbucket
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

class BitbucketAdapter : BindingListAdapter<Bitbucket, BitbucketAdapter.BitbucketViewHolder>(diffUtil) {

    private var onClickedAt = 0L

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitbucketViewHolder {
        val binding = parent.binding<ItemBitbucketBinding>(R.layout.item_bitbucket)
        return BitbucketViewHolder(binding).apply {
            binding.root.setOnClickListener {

            }
        }
    }

    override fun onBindViewHolder(holder: BitbucketViewHolder, position: Int) {
        holder.binding.apply {
            bitbucket = getItem(position)
            executePendingBindings()
        }
    }

    class BitbucketViewHolder(val binding: ItemBitbucketBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Bitbucket>() {

            override fun areItemsTheSame(oldItem: Bitbucket, newItem: Bitbucket): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Bitbucket, newItem: Bitbucket): Boolean =
                oldItem == newItem
        }
    }
}