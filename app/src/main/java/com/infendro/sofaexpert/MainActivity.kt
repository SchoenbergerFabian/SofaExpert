package com.infendro.sofaexpert

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors


class MainActivity : AppCompatActivity() {

    companion object{
        val IMAGEURL = "http://image.tmdb.org/t/p/w154/"
        lateinit var activity : Activity
        lateinit var movies : List<Movie>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this

        movies = readJSON()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun readJSON() : List<Movie>{
        val content = readJSONFile()

        val jsonObject = JSONObject(content)
        val jsonArray = jsonObject.getJSONArray("results")

        val movies = ArrayList<Movie>()
        for( index in 0 until jsonArray.length()){
            val obj = jsonArray.getJSONObject(index)
            movies.add(Movie(obj.getDouble("vote_average"),
                                obj.getString("title"),
                                obj.getString("poster_path"),
                                obj.getString("overview"),
                                obj.getString("release_date")))
        }
        return movies
    }

    fun readJSONFile() : String {
        return BufferedReader(InputStreamReader(assets.open("movies.json"))).lines().collect(Collectors.joining("\n"))
    }
}