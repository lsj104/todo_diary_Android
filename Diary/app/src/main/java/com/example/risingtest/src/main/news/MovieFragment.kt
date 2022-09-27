package com.example.risingtest.src.main.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.list.movie.Movie
import com.example.risingtest.src.main.list.movie.MovieDetailsActivity
import com.example.risingtest.src.main.list.movie.MoviesAdapter
import com.example.risingtest.src.main.list.movie.MoviesRepository

class MovieFragment : Fragment() {
    lateinit var root: View

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private var popularMoviesPage = 1


    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(activity, MovieDetailsActivity::class.java)
        intent.putExtra(MainActivity.MOVIE_BACKDROP, movie.backdrop_path)
        intent.putExtra(MainActivity.MOVIE_POSTER, movie.poster_path)
        intent.putExtra(MainActivity.MOVIE_TITLE, movie.title)
        intent.putExtra(MainActivity.MOVIE_RATING, movie.rating)
        intent.putExtra(MainActivity.MOVIE_RELEASE_DATE, movie.releaseDate)
        intent.putExtra(MainActivity.MOVIE_OVERVIEW, movie.overview)
        startActivity(intent)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {


        root = inflater.inflate(R.layout.fragment_news, container, false)

        popularMovies = root.findViewById(R.id.popular_movies)
        popularMoviesLayoutMgr = GridLayoutManager(context,2)
        popularMovies.layoutManager = popularMoviesLayoutMgr
        popularMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        popularMovies.adapter = popularMoviesAdapter


        getPopularMovies()



        return root
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMovies.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
                }
            }
        })
    }




    private fun onError() {
        Toast.makeText(activity, "error Movies", Toast.LENGTH_SHORT).show()
    }



}