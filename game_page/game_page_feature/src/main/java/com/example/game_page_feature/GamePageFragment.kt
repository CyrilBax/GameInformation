package com.example.game_page_feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.game_page_feature.databinding.GamePageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamePageFragment : Fragment() {

    private lateinit var binding: GamePageFragmentBinding
    private val gameId: String
        get() = arguments?.getString(ARG_GAME_ID)
            ?: throw IllegalStateException()
    private val viewModel: GamePageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGamePage(gameId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GamePageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gamePage.observe(viewLifecycleOwner) {
            binding.gameIdText.text = it.name
        }
    }

    companion object {
        private const val ARG_GAME_ID = "ARG_GAME_ID"

        fun newInstance(gameId: String): GamePageFragment {
            val bundle = Bundle().apply { putString(ARG_GAME_ID, gameId) }
            return GamePageFragment().apply {
                arguments = bundle
            }
        }
    }

}