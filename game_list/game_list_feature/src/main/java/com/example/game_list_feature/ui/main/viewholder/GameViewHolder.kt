package com.example.game_list_feature.ui.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.game_list_domain.models.PlatformUi
import com.example.game_list_feature.databinding.GameItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import javax.inject.Inject

class GameViewHolder @Inject constructor(
    private val binding: GameItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        picture: String,
        title: String,
        platforms: List<PlatformUi>?,
        onGameClicked: (Unit) -> Unit
    ) {
        platforms?.let { showPlatforms(it) }
        binding.apply {
            gameCard.setOnClickListener { onGameClicked.invoke(Unit) }
            hideErrorPictureIfNecessary()
            gamePictureLoading.show()
            gameTitle.text = title
            Picasso.get()
                .load(picture)
                .resize(200, 0) // Use 0 to preserve picture ratio
                .onlyScaleDown()
                .centerInside()
                .into(gamePicture, object : Callback {
                    override fun onSuccess() {
                        hideLoading()
                        hideErrorPictureIfNecessary()
                        gamePicture.visibility = View.VISIBLE
                    }

                    override fun onError(e: Exception?) {
                        hideLoading()
                        pictureError.visibility = View.VISIBLE
                        gamePicture.visibility = View.GONE
                    }

                })
        }
    }

    private fun hideLoading() {
        binding.gamePictureLoading.apply {
            hide()
            visibility = View.GONE
        }
    }

    private fun hideErrorPictureIfNecessary() {
        if (binding.pictureError.visibility == View.VISIBLE) {
            binding.pictureError.visibility = View.GONE
        }
    }

    private fun showPlatforms(platforms: List<PlatformUi>) {
            binding.gameListPlatformsView.initPlatformsView(platforms)
    }
}
