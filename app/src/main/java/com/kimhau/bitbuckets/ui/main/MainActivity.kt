package com.kimhau.bitbuckets.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.kimhau.bitbuckets.R
import com.kimhau.bitbuckets.databinding.ActivityMainBinding
import com.kimhau.bitbuckets.ui.adapter.BitbucketAdapter
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    @VisibleForTesting
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@MainActivity
            adapter = BitbucketAdapter()
            vm = viewModel
        }
    }
}