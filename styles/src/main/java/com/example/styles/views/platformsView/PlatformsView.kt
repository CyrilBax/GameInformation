package com.example.styles.views.platformsView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.game_list_domain.models.PlatformUi
import com.example.styles.databinding.PlatformsViewBinding

class PlatformsView constructor(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {

    private val binding = PlatformsViewBinding.inflate(LayoutInflater.from(context), this)

    fun initPlatformsView(platforms: List<PlatformUi>) {
        binding.apply {
            platforms.forEach { platform ->
                when (platform.name) {
                    XBOX -> logoXbox.visibility = View.VISIBLE
                    ANDROID -> logoAndroid.visibility = View.VISIBLE
                    ATARI -> logoAtari.visibility = View.VISIBLE
                    COMMODORE_AMIGA -> logoCommodoreAmiga.visibility = View.VISIBLE
                    IOS -> logoIos.visibility = View.VISIBLE
                    LINUX -> logoLinux.visibility = View.VISIBLE
                    MAC -> logoMac.visibility = View.VISIBLE
                    NEO_GEO -> logoNeoGeo.visibility = View.VISIBLE
                    NINTENDO -> logoNintendo.visibility = View.VISIBLE
                    PLAYSTATION -> logoPlaystation.visibility = View.VISIBLE
                    SEGA -> logoSega.visibility = View.VISIBLE
                    THREE_DO -> logoThreedo.visibility = View.VISIBLE
                    WEB -> logoWeb.visibility = View.VISIBLE
                    WINDOWS -> logoWindows.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        private const val XBOX = "xbox"
        private const val ANDROID = "android"
        private const val ATARI = "atari"
        private const val COMMODORE_AMIGA = "commodore-amiga"
        private const val IOS = "ios"
        private const val LINUX = "linux"
        private const val MAC = "mac"
        private const val NEO_GEO = "neo-geo"
        private const val NINTENDO = "nintendo"
        private const val PLAYSTATION = "playstation"
        private const val SEGA = "sega"
        private const val THREE_DO = "3do"
        private const val WEB = "web"
        private const val WINDOWS = "pc"
    }
}