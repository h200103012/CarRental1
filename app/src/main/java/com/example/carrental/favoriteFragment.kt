package com.example.carrental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.carrental.R.layout.*
import com.example.carrental.adapter.FavAdapter
import com.example.carrental.databinding.FragmentFavoriteBinding
import com.example.carrental.model.FavModel
import kotlinx.android.synthetic.main.catalog.*



class favoriteFragment : Fragment(R.layout.fragment_favorite) {
    lateinit var binding: FragmentFavoriteBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FavAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {
        val viewModel = ViewModelProvider(this).get(favoriteViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvFaves
        adapter = FavAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllFaves().observe(viewLifecycleOwner) { listFaves ->
            listFaves.asReversed()
            adapter.setList(listFaves)
        }
//
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_favoriteFragment_to_addFavFragment)
        }
    }


    companion object{
        fun clickFav(favModel: FavModel){
            val bundle = Bundle()
            bundle.putSerializable("fav",favModel)
            APP.navController.navigate(R.id.action_favoriteFragment_to_detailFragment,bundle)
        }
    }
}


