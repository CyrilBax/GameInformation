package com.example.game_list_feature.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.game_list_feature.databinding.GameListFragmentBinding
import com.example.game_list_feature.ui.main.adapter.GameAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameListFragment : Fragment() {

    private lateinit var binding: GameListFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var gameAdapter: GameAdapter

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
        gameAdapter = GameAdapter()

        binding.gameRecyclerView.apply {
            adapter = gameAdapter
            (layoutManager as GridLayoutManager).apply {
                orientation = GridLayoutManager.VERTICAL
                spanCount = 2
            }
            adapter = gameAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!binding.gameRecyclerView.canScrollVertically(View.SCROLL_AXIS_VERTICAL)) {
                        viewModel.getGameList()
                    }
                }
            })
        }

        viewModel.gameList.observe(viewLifecycleOwner) {
            gameAdapter.setGameList(it)
        }
    }

    companion object {
        fun newInstance() = GameListFragment()
    }

}