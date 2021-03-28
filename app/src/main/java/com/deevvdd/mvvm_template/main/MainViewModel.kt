package com.deevvdd.mvvm_template.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deevvdd.domain.model.Movie
import com.deevvdd.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : ViewModel() {
    val popularMovies = MutableLiveData<List<Movie>>()
    init {
        fetchMovies()
    }
    fun fetchMovies() = viewModelScope.launch {
        useCase.getMovies().let { data ->
            Log.d("Response ", "Response ${data}")
            popularMovies.value = data
        }
    }
}