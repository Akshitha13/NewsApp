package com.example.newsapp.mvvmnewsapp.ui.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.mvvmnewsapp.ui.database.ArticleDatabase
import com.example.newsapp.mvvmnewsapp.ui.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository = repository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]
        binding.bottomNavigationView.setupWithNavController(binding.newsNavHostFragment.getFragment<NavHostFragment>().navController)
    }
}