package com.example.carrental.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.carrental.APP
import com.example.carrental.R
import com.example.carrental.databinding.FragmentDetailBinding
import com.example.carrental.model.FavModel

// TODO: Rename parameter arguments, choose names that match

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var currentFav: FavModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentFav = arguments?.getSerializable("fav") as FavModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentFav.title
        binding.tvDescDetail.text = currentFav.description
        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentFav){}
            APP.navController.navigate(R.id.action_detailFragment_to_favoriteFragment)

        }

        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_favoriteFragment)
        }

    }

}