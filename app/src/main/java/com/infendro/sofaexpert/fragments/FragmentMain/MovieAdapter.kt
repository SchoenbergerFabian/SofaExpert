package com.infendro.sofaexpert.fragments.FragmentMain

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.infendro.sofaexpert.MainActivity
import com.infendro.sofaexpert.Movie
import com.infendro.sofaexpert.R
import com.squareup.picasso.Picasso

class MovieAdapter(private val context: Activity, var movies: List<Movie>) : ArrayAdapter<Movie>(context, R.layout.view_movieposter, movies) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = when(convertView){
            null -> context.layoutInflater.inflate(R.layout.view_movieposter,null,true)
            else -> convertView
        }

        Picasso.get().load(MainActivity.IMAGEURL+getItem(position)?.poster_path).into(view.findViewById<ImageView>(R.id.poster))

        return view
    }

    override fun getItem(position: Int): Movie? {
        return movies[position]
    }
}