package com.example.game_list_feature.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.game_list_domain.models.GameLightUi
import com.example.game_list_feature.databinding.GameItemBinding
import com.example.game_list_feature.ui.main.viewholder.GameViewHolder
import javax.inject.Inject

class GameAdapter @Inject constructor() : RecyclerView.Adapter<GameViewHolder>() {

    private var gameList: MutableList<GameLightUi> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setGameList(gameList: List<GameLightUi>) {
        this.gameList.addAll(gameList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameViewHolder(
        GameItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(
            gameList[position].picture ?: "empty",
            gameList[position].name ?: "",
            gameList[position].platforms
        )
    }

    override fun getItemCount(): Int = gameList.size
}