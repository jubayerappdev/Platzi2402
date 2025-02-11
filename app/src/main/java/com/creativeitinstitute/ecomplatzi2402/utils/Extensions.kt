package com.creativeitinstitute.ecomplatzi2402.utils

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.creativeitinstitute.ecomplatzi2402.R


fun ImageView.load(imageUrl:String){


   this.load(imageUrl){
       placeholder(R.drawable.placeholder)
       error(R.drawable.placeholder_error)
       diskCachePolicy(CachePolicy.ENABLED)
   }
}