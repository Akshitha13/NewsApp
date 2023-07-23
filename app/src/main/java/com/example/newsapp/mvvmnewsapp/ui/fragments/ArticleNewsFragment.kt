package com.example.newsapp.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.databinding.FragmentArticleBinding
import com.example.newsapp.mvvmnewsapp.ui.ui.NewsActivity
import com.example.newsapp.mvvmnewsapp.ui.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleNewsFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private val args: ArticleNewsFragmentArgs by navArgs()
    private lateinit var binding: FragmentArticleBinding

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
                binding = FragmentArticleBinding.inflate(inflater, container, false)
                return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        binding.fab.setOnClickListener {
            
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
        }
    }
}