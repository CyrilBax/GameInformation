package com.example.game_page_feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.game_page_feature.databinding.GamePageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamePageFragment : Fragment() {

    private lateinit var binding: GamePageFragmentBinding
    private val gameId: String
        get() = arguments?.getString(ARG_GAME_ID)
            ?: throw IllegalStateException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GamePageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameIdText.text = gameId
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