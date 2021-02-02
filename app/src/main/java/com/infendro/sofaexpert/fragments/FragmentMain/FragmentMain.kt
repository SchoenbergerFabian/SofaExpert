package com.infendro.sofaexpert.fragments.FragmentMain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.infendro.sofaexpert.MainActivity
import com.infendro.sofaexpert.R
import com.infendro.sofaexpert.fragments.FragmentDetail
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movieAdapter = MovieAdapter(MainActivity.activity,MainActivity.movies)
        gridView.adapter = movieAdapter
        gridView.setOnItemClickListener { _, _, position, _ ->
            FragmentDetail.movie = movieAdapter.getItem(position)
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentDetail)
        }
    }

}