package com.deevvdd.mvvm_template

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deevvdd.domain.model.Movie
import com.deevvdd.mvvm_template.databinding.ItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieVH>() {
    private val movies = ArrayList<Movie>()

    fun setMovies(list: List<Movie>) {
        this.movies.addAll(list)
        this.notifyDataSetChanged()
    }

    inner class MovieVH(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.onBind(movie = movies[position])
    }

    override fun getItemCount() = movies.count()
}