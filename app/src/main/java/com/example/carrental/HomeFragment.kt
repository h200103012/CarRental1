package com.example.carrental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home2, container, false)
        val login = view.findViewById<Button>(R.id.FragmentLogbutton)
        login.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registrationFragment)
        }
        val faq = view.findViewById<Button>(R.id.button2)
        faq.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_faqFragment)
        }
        val catalog = view.findViewById<Button>(R.id.catalogButton)
        catalog.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_catalogFragment)
        }
        val discount = view.findViewById<Button>(R.id.button4)
        discount.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_discountFragment)
        }
        return view
    }
}
