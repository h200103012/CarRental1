package com.example.carrental.screens.addFav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.carrental.APP
import com.example.carrental.R
import com.example.carrental.databinding.FragmentAddFavBinding
import com.example.carrental.model.FavModel

class AddFavFragment : Fragment() {
    lateinit var binding: FragmentAddFavBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddFavBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddFavViewModel::class.java)
        binding.btnAdd.setOnClickListener() {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDesc.text.toString()
            viewModel.insert(FavModel(title = title, description = description)) {}
            APP.navController.navigate(R.id.action_addFavFragment_to_favoriteFragment)
        }
        binding.btnBack.setOnClickListener(){
            APP.navController.navigate(R.id.action_addFavFragment_to_favoriteFragment)
        }
    }

}