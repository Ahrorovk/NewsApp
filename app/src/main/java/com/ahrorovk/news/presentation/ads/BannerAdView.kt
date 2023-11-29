package com.ahrorovk.news.presentation.ads

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAdView() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                setAdSize(
                    AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
                        context,
                        AdSize.BANNER.width
                    )
                )
                adUnitId = AdsConstants.BANNER_AD_UNIT
                loadAd(AdRequest.Builder().build())
                Log.e("BANNERAD","-> $this \n $adUnitId")
            }
        }
    )
}