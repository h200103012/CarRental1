package com.example.carrental

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CatalogActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<CarData>()
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = CarAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<CarData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(
            CarData(
                "Mercedes-Benz SLS AMG",
                R.drawable.logomers,
                "A rare car from Germany, that gives you an unforgettable feelings and feeling of freedom"
            )
        )
        mList.add(
            CarData(
                "BMW M8 GranCoupe",
                R.drawable.logobmw,
                "The Beast into Sheep's clothing. Gives you all spectre of emotions and bit more"
            )
        )
        mList.add(
            CarData(
                "McLaren 720s",
                R.drawable.logomc,
                "British of Royal Blood"
            )
        )
        mList.add(
            CarData(
                "Lamborghini Huracan",
                R.drawable.logolambo,
                "Not horsepower but bullish under the hood of this passionate Italian"
            )
        )
        mList.add(
            CarData(
                "Ferrari 812 Superfast",
                R.drawable.logoferrari,
                "True Italian in a beautiful performance"

            )
        )
        mList.add(
            CarData(
                "Lexus LFA",
                R.drawable.logolexus,
                "A real rarity car! The True Samurai!"
            )
        )
        mList.add(
            CarData(
                "Nissan GTR",
                R.drawable.logonissan,
                "GODZILLA in real voice"
            )
        )
        mList.add(
            CarData(
                "Toyota Supra A90",
                R.drawable.logotoyota,
                "New Car!"
            )
        )
    }
}