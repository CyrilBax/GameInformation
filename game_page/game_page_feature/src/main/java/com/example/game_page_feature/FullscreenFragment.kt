package com.example.game_page_feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.game_page_feature.databinding.FragmentFullscreenBinding
import com.squareup.picasso.Picasso

class FullscreenFragment : Fragment() {

    private val gamePicture: String
        get() = arguments?.getString(ARG_GAME_PICTURE_URL) ?: throw IllegalStateException()

    private lateinit var binding: FragmentFullscreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullscreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gamePictureFullScreen.apply {
            Picasso.get()
                .load(gamePicture)
                .into(this)

            setOnClickListener {
                activity?.supportFragmentManager?.popBackStack()
            }

            this.maximumScale = 40.0f
        }
    }

    companion object {
        private const val ARG_GAME_PICTURE_URL = "ARG_GAME_PICTURE_URL"

        fun newInstance(gamePicture: String): FullscreenFragment {
            val bundle = Bundle().apply { putString(ARG_GAME_PICTURE_URL, gamePicture) }
            return FullscreenFragment().apply {
                arguments = bundle
            }
        }
    }
}