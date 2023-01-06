package com.example.news

sealed class Graph(val route: String) {
    object InfoGraph : Graph("HomeGraph")
    object FavoriteGraph : Graph("FavoriteGraph")
}