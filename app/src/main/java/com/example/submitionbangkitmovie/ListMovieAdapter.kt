package com.example.submitionbangkitmovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_poster)
        val tvName: TextView = itemView.findViewById(R.id.tv_judul)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_tahun)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, years, genre, duration, director, caster, distributor, photo) = listMovie[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = years

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,listMovie[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DetailMovie::class.java)
            intent.putExtra("movie_name", name)
            intent.putExtra("movie_description", description)
            intent.putExtra("movie_years", years)
            intent.putExtra("movie_genre", genre)
            intent.putExtra("movie_duration", duration)
            intent.putExtra("movie_director", director)
            intent.putExtra("movie_caster", caster)
            intent.putExtra("movie_distributor", distributor)
            intent.putExtra("movie_photo", photo)
            holder.itemView.context.startActivity(intent)
        }
    }



}