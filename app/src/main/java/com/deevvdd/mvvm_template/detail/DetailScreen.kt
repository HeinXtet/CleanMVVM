package com.deevvdd.mvvm_template.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deevvdd.mvvm_template.common.ui.viewBinding
import com.deevvdd.mvvm_template.databinding.ActivityDetailBinding

class DetailScreen : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvDetail.text = "HELLO"

    }
}