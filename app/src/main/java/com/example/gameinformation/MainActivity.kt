package com.example.gameinformation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.business.contracts.NavigationContract
import com.example.game_list_feature.ui.main.GameListFragment
import com.example.game_page_feature.FullscreenFragment
import com.example.game_page_feature.GamePageFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_activity, GameListFragment.newInstance())
        }.commit()
    }

    override fun navigateToGamePage(gameId: String) {
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().run {
            addToBackStack(null)
            replace(R.id.main_activity, GamePageFragment.newInstance(gameId))
        }.commit()
    }

    override fun showPictureInFullScreen(url: String) {
        supportFragmentManager.beginTransaction().run {
            addToBackStack(null)
            replace(R.id.main_activity, FullscreenFragment.newInstance(url))
        }.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.last() is GameListFragment) {
            supportActionBar?.show()
        }
    }

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}