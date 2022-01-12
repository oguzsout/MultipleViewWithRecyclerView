package com.oguzdogdu.multipleviewwithrecyclerview.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzdogdu.multipleviewwithrecyclerview.databinding.ActivityMainBinding
import com.oguzdogdu.multipleviewwithrecyclerview.util.Resource
import com.oguzdogdu.multipleviewwithrecyclerview.util.hide
import com.oguzdogdu.multipleviewwithrecyclerview.util.show
import com.oguzdogdu.multipleviewwithrecyclerview.util.snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val homeRecyclerViewAdapter = HomeRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = homeRecyclerViewAdapter
        }

        homeRecyclerViewAdapter.itemClickListener = { view, item, position ->
            val message = when (item) {
                is HomeRecyclerViewItem.Director -> "Director ${item.name} Clicked"
                is HomeRecyclerViewItem.Movie -> "Movie ${item.title} Clicked"
                is HomeRecyclerViewItem.Title -> "View All Clicked"
            }
            snackbar(message)
        }

        viewModel.homeListItemsLiveData.observe(this) { result ->
            when (result) {
                is Resource.Failure -> {
                    binding.progressBar.hide()
                    //handle failure case here
                }
                Resource.Loading -> binding.progressBar.show()
                is Resource.Success -> {
                    binding.progressBar.hide()
                    homeRecyclerViewAdapter.items = result.value
                }
            }
        }
    }
}