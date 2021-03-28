package com.deevvdd.mvvm_template.common.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.deevvdd.mvvm_template.R

object ViewBindingExt{

    @BindingAdapter("android:imageUrl","android:errorImage")
    @JvmStatic
    fun setImage(view: ImageView, url: String, error: Drawable) {
        if (url.isNotEmpty()) {
            Glide.with(view.context).load(url).centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(view)
        } else {
            view.setImageDrawable(error)
        }
    }
}