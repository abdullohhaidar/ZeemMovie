package com.example.submitionbangkitmovie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovie: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvMovie = findViewById(R.id.rv_movie)
        rvMovie.setHasFixedSize(true)

        list.addAll(getListMovie())
        showRecylerlist()
    }

    private fun getListMovie(): ArrayList<Movie>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataYears = resources.getStringArray(R.array.data_years)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val dataDirector = resources.getStringArray(R.array.data_director)
        val dataCaster = resources.getStringArray(R.array.data_caster)
        val dataDistributor = resources.getStringArray(R.array.data_distributor)
        val listMovie = ArrayList<Movie>()
        for (i in dataName.indices){
            val movie = Movie(dataName[i],dataDescription[i],dataYears[i],dataGenre[i],dataDuration[i],dataDirector[i],dataCaster[i],dataDistributor[i], dataPhoto.getResourceId(i, -1))
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecylerlist() {
        rvMovie.layoutManager = GridLayoutManager(this, 2)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovie.adapter = listMovieAdapter
    }

    fun showAboutPage(view: View) {
        val intent = Intent(this, AboutMe::class.java)
        startActivity(intent)
    }
}