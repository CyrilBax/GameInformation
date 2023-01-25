package com.example.business.contracts

interface NavigationContract {
    fun navigateToGamePage(gameId: String)

    fun showPictureInFullScreen(url: String)
}