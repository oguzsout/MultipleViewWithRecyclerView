package com.oguzdogdu.multipleviewwithrecyclerview.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.oguzdogdu.multipleviewwithrecyclerview.R
import com.oguzdogdu.multipleviewwithrecyclerview.databinding.ItemDirectorBinding
import com.oguzdogdu.multipleviewwithrecyclerview.databinding.ItemMovieBinding
import com.oguzdogdu.multipleviewwithrecyclerview.databinding.ItemTitleBinding
import com.oguzdogdu.multipleviewwithrecyclerview.util.loadImage


sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: ItemTitleBinding) : HomeRecyclerViewHolder(binding) {
        fun bind(title: HomeRecyclerViewItem.Title) {
            binding.textViewTitle.text = title.title
        }
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : HomeRecyclerViewHolder(binding) {
        fun bind(movie: HomeRecyclerViewItem.Movie) {
            binding.imageViewMovie.loadImage(movie.thumbnail)
        }
    }

    class DirectorViewHolder(private val binding: ItemDirectorBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(director: HomeRecyclerViewItem.Director) {
            binding.imageViewDirector.loadImage(director.avatar)
            binding.textViewName.text = director.name
            binding.textViewMovies.text = binding.textViewMovies.context.getString(
                R.string.total_movies,
                director.movie_count
            )
        }
    }
}
