package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tolong_aku.Berita.db.ArticleDatabase
import com.example.tolong_aku.Berita.repository.NewsRepository
import com.example.tolong_aku.Berita.ui.NewsViewModel
import com.example.tolong_aku.Berita.ui.NewsViewModelProviderFactory
import com.example.tolong_aku.Berita.ui.fragments.FavouritesFragment
import com.example.tolong_aku.Berita.ui.fragments.HeadlinesFragment
import com.example.tolong_aku.Berita.ui.fragments.SearchFragment
import com.example.tolong_aku.databinding.ActivityMainMenuBinding
import com.example.tolong_aku.databinding.ActivityNewsBinding

class MainMenu : AppCompatActivity(){
    private lateinit var binding : ActivityMainMenuBinding
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding2: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        binding2 = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding2.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.ulasan -> replaceFragment(Ulasan())
//                R.id.-> NewsActivity()
//                R.id.berita-> replaceFragment(berita())
                R.id.headlines -> replaceFragment(HeadlinesFragment())
                R.id.favourites -> replaceFragment(FavouritesFragment())
                R.id.search -> replaceFragment(SearchFragment())


                else -> {

                }
            }
            true
        }

    }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}