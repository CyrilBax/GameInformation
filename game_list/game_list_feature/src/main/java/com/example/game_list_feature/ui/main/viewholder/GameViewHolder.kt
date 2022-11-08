package com.example.game_list_feature.ui.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.game_list_feature.databinding.GameItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import javax.inject.Inject

class GameViewHolder @Inject constructor(
    private val binding: GameItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        picture: String,
        title: String
    ) {
        binding.apply {
            gamePictureLoading.show()
            gameTitle.text = title
            Picasso.get()
                .load(picture)
                .into(gamePicture, object : Callback {
                    override fun onSuccess() {
                        hideLoading()
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

    fun hideLoading() {
        binding.gamePictureLoading.apply {
            hide()
            visibility = View.GONE
        }
    }
}
