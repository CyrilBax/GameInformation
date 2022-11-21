package com.example.gameinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.business.communication.NavigationContract
import com.example.game_list_feature.ui.main.GameListFragment
import com.example.game_page_domain.GamePageFragment
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
        supportFragmentManager.beginTransaction().run {
            addToBackStack(null)
            replace(R.id.main_activity, GamePageFragment.newInstance(gameId))
        }.commit()
    }
}