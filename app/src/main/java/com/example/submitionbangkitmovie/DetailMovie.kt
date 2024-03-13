package com.example.submitionbangkitmovie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailMovie : AppCompatActivity() {

    private var movieName: String? = null
    private var movieDescription: String? = null
    private var movieYears: String? = null
    private var movieGenre: String? = null
    private var movieDuration: String? = null
    private var movieDirector: String? = null
    private var movieCaster: String? = null
    private var movieDistributor: String? = null
    private var moviePhoto: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_movie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movieName = intent.getStringExtra("movie_name")
        val movieDescription = intent.getStringExtra("movie_description")
        val movieYears = intent.getStringExtra("movie_years")
        val movieGenre = intent.getStringExtra("movie_genre")
        val movieDuration = intent.getStringExtra("movie_duration")
        val movieDirector = intent.getStringExtra("movie_director")
        val movieCaster = intent.getStringExtra("movie_caster")
        val movieDistributor = intent.getStringExtra("movie_distributor")
        val moviePhoto = intent.getIntExtra("movie_photo", 0)
        val btnShare = findViewById<Button>(R.id.btn_share)



        // Menampilkan data pada tampilan detail film
        val tvMovieName = findViewById<TextView>(R.id.detail_judul)
        val tvMovieDescription = findViewById<TextView>(R.id.detail_deskripsi)
        val tvMovieYears = findViewById<TextView>(R.id.detail_tahun)
        val tvMovieGenre = findViewById<TextView>(R.id.detail_genre)
        val tvMovieDuration = findViewById<TextView>(R.id.detail_duration)
        val tvMovieDirector = findViewById<TextView>(R.id.detail_director)
        val tvMovieCaster = findViewById<TextView>(R.id.detail_caster)
        val tvMovieDistributor = findViewById<TextView>(R.id.detail_distributor)
        val imgMoviePhoto = findViewById<ImageView>(R.id.detail_poster)

        tvMovieName.text = movieName
        tvMovieDescription.text = movieDescription
        tvMovieYears.text = movieYears
        tvMovieGenre.text = movieGenre
        tvMovieDuration.text = movieDuration
        tvMovieDirector.text = movieDirector
        tvMovieCaster.text = movieCaster
        tvMovieDistributor.text = movieDistributor
        imgMoviePhoto.setImageResource(moviePhoto)


        btnShare.setOnClickListener {
            shareMovieDetails()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareMovieDetails()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareMovieDetails() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, movieName)
        val shareMessage = """
            Film: $movieName
            Deskripsi: $movieDescription
            Tahun: $movieYears
            Genre: $movieGenre
            Durasi: $movieDuration
            Sutradara: $movieDirector
            Pemeran: $movieCaster
            Distributor: $movieDistributor
        """.trimIndent()
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "Bagikan informasi film"))
    }
}