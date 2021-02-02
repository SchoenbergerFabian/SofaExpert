package com.infendro.sofaexpert.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.infendro.sofaexpert.MainActivity
import com.infendro.sofaexpert.Movie
import com.infendro.sofaexpert.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class FragmentDetail : Fragment() {

    companion object{
        var movie: Movie? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        title.text=movie?.title
        rating.text=""+movie?.vote_average+" / 10"
        Picasso.get().load(MainActivity.IMAGEURL+movie?.poster_path).into(view.findViewById<ImageView>(R.id.poster))
        releaseDate.text=movie?.release_date
        description.text=movie?.overview
    }

}