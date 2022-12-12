package com.example.carrental

data class CarData (
    val title: String,
    val logo: Int,
    val desc: String,
    var isExpandable: Boolean = false
    )