package com.deevvdd.mvvm_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.deevvdd.domain.model.Movie
import com.deevvdd.mvvm_template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = MovieAdapter()
        binding.apply {
            vm = mainViewModel
            rvMovie.layoutManager = LinearLayoutManager(this@MainActivity)
            rvMovie.adapter = adapter
        }
        mainViewModel.popularMovies.observe(this, {
            adapter.setMovies(it)
        })
    }
}