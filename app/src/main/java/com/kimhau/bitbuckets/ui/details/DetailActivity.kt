package com.kimhau.bitbuckets.ui.details

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import com.kimhau.bitbuckets.R
import com.kimhau.bitbuckets.databinding.ActivityDetailBinding
import com.kimhau.bitbuckets.model.Bitbucket
import com.skydoves.bindables.BindingActivity
import com.skydoves.bundler.bundleNonNull
import com.skydoves.bundler.intentOf
import com.skydoves.whatif.whatIfNotNullAs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val detailsItem: Bitbucket by bundleNonNull(EXTRA_DETAIL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@DetailActivity
            details = detailsItem
        }
    }

    companion object {
        @VisibleForTesting
        const val EXTRA_DETAIL = "EXTRA_DETAIL"

        fun startActivity(context: Context?, detailsItem: Bitbucket){
            context.whatIfNotNullAs <Activity> {
                it.intentOf<DetailActivity> {
                    putExtra(EXTRA_DETAIL to detailsItem)
                    startActivity(it)
                }
            }
        }
    }
}