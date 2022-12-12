package com.example.carrental

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrental.adapters.RecyclerAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val BASE_URL = "https://newsapi.org"

class HomeFragment: Fragment() {




    lateinit var countdownTimer: CountDownTimer
    private var seconds = 3L


    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<String>()
    private var linksList = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeAPIRequest()
    }






    private fun fadeIn() {
        v_blackScreen.animate().apply {
            alpha(0f)
            duration = 3000
        }.start()
    }



    private fun makeAPIRequest() {
        progressBar.visibility = View.VISIBLE

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getNews()

                for (article in response.articles) {
                    Log.d("HomeFragment", "Result + $article")
                    addToList(article.title, article.description, article.image, article.url)
                }

                withContext(Dispatchers.Main) {
                    setUpRecyclerView()
                    fadeIn()
                    progressBar.visibility = View.GONE
                }
            } catch (e: Exception) {
                Log.d("HomeFragment", e.toString())
                withContext(Dispatchers.Main) {
                    attemptRequestAgain(seconds)

                }
            }

        }
    }

    private fun attemptRequestAgain(seconds: Long) {
        countdownTimer = object: CountDownTimer(seconds*1010,1000){
            override fun onFinish() {
                makeAPIRequest()
                countdownTimer.cancel()
                tv_noInternetCountDown.visibility = View.GONE
                this@HomeFragment.seconds+=3
            }
            override fun onTick(millisUntilFinished: Long) {
                tv_noInternetCountDown.visibility = View.VISIBLE
                tv_noInternetCountDown.text = "Cannot retrieve data...\nTrying again in: ${millisUntilFinished/1000}"
                Log.d("HomeFragment", "Could not retrieve data. Trying again in ${millisUntilFinished/1000} seconds")
            }
        }
        countdownTimer.start()
    }

    private fun setUpRecyclerView() {
        val applicationContext = null
        rv_recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        rv_recyclerView.adapter = RecyclerAdapter(titlesList, descList, imagesList, linksList)
    }

    //adds the items to our recyclerview
    private fun addToList(title: String, description: String, image: String, link: String) {
        linksList.add(link)
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }
}



