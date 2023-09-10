package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.movies.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        getMovies()
        setContentView(binding.root)



    }

    private fun getMovies() {
     lifecycleScope.launch(Dispatchers.IO) {

         val res = ApiUtilities.getInstance().create(ApiInterface :: class.java).getMoviesData()

        // Log.d("SHUBH", "getMovies: ${res.body()!!.results}")

         withContext(Dispatchers.Main){
             binding.moviesRv.adapter = MoviesAdapters(this@MainActivity,res.body()!!.results)
         }
     }
    }
}