package com.example.gameinformation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.business.contracts.NavigationContract
import com.example.game_list_feature.ui.main.GameListFragment
import com.example.game_page_feature.FullscreenFragment
import com.example.game_page_feature.GamePageFragment
import com.example.gameinformation.R
import com.example.gameinformation.domain.repositories.models.RemoteConfigResult
import com.example.gameinformation.domain.usecases.InitFirebaseRemoteConfigUseCase
import com.example.gameinformation.domain.usecases.IsComposeEnableUseCase
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationContract {

    @Inject
    lateinit var initFirebaseRemoteConfigUseCase: InitFirebaseRemoteConfigUseCase

    @Inject
    lateinit var isComposeEnableUseCase: IsComposeEnableUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            initFirebaseRemoteConfigUseCase.execute {
                when (it) {
                    is RemoteConfigResult.Success -> {
                        val composeEnable = isComposeEnableUseCase.execute()
                        if (composeEnable) {
                            Timber.d("Compose is enable")
                            openApplicationInCompose()
                        } else {
                            Timber.d("Compose is disable")
                            openApplicationWithoutCompose()
                        }
                    }
                    else -> {
                        Timber.e(it.toString())
                        openApplicationWithoutCompose()
                    }
                }
            }
        }
    }

    private fun openApplicationInCompose() {
        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_activity, GameListFragment.newInstance())
        }.commit()
    }

    private fun openApplicationWithoutCompose() {
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