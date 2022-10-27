package com.example.game_list_feature.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.game_list_feature.databinding.GameListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameListFragment : Fragment() {

    private lateinit var binding: GameListFragmentBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModel can be called in onCreate
        // To save time i's better to call him as soon as possible
        viewModel.getGameList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = GameListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gameList.observe(viewLifecycleOwner) {
            binding.message.text = it.firstOrNull()?.name
        }
    }

    companion object {
        fun newInstance() = GameListFragment()
    }

}