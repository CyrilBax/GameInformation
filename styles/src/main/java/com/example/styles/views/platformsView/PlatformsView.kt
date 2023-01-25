package com.example.styles.views.platformsView

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginStart
import com.example.styles.R
import com.example.styles.databinding.PlatformsViewBinding
import java.util.Objects

class PlatformsView constructor(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {

    private val binding = PlatformsViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        val attributeArray: TypedArray? = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PlatformsView,
            0, 0
        )
        val isBig = attributeArray?.getBoolean(R.styleable.PlatformsView_isBig, false)
        isBig?.let {
            if (it) {
                setBigSize()
            }
        }
        attributeArray?.recycle()
    }

    fun initPlatformsView(
        platforms: List<com.example.game_list_domain.models.PlatformUi>?,
        platformsPage: List<com.example.game_page_domain.models.PlatformUi>?
    ) {
        platforms?.forEach { platform ->
            checkLogoToDisplay(platform.name)
        }
        platformsPage?.forEach { platform ->
            checkLogoToDisplay(platform.name)
        }
    }

    private fun checkLogoToDisplay(name: String?) {
        binding.apply {
            return when (name) {
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
                else -> {}
            }
        }
    }

    private fun setBigSize() {
        binding.apply {
            logoXbox.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoAndroid.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoAtari.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoCommodoreAmiga.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoIos.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoLinux.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoMac.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoNeoGeo.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoNintendo.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoPlaystation.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoSega.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoThreedo.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoWeb.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
                }
            }
            logoWindows.apply {
                layoutParams.apply {
                    height = resources.getDimension(R.dimen.platform_size_big).toInt()
                    width = resources.getDimension(R.dimen.platform_size_big).toInt()
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