package com.example.gameinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game_list_feature.ui.main.GameListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_activity, GameListFragment.newInstance())
        }.commit()
        //TODO: add cmake for api key
        //key b93e15401f5e4b6ba8e982d50e192f75
    }
}