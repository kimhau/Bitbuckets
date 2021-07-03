package com.kimhau.bitbuckets.ui.webview

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import com.kimhau.bitbuckets.R
import com.kimhau.bitbuckets.databinding.ActivityWebviewBinding
import com.skydoves.bindables.BindingActivity
import com.skydoves.bundler.bundleNonNull
import com.skydoves.bundler.intentOf
import com.skydoves.whatif.whatIfNotNullAs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebviewActivity : BindingActivity<ActivityWebviewBinding>(R.layout.activity_webview) {
    private val urlStr: String by bundleNonNull(EXTRA_URL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@WebviewActivity
            url = urlStr
        }
    }

    companion object {
        @VisibleForTesting
        const val EXTRA_URL = "EXTRA_URL"

        fun startActivity(context: Context?, urlStr: String){
            context.whatIfNotNullAs <Activity> {
                it.intentOf<WebviewActivity> {
                    putExtra(EXTRA_URL to urlStr)
                    startActivity(it)
                }
            }
        }
    }
}