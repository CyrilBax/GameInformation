package com.example.game_page_feature

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.business.contracts.NavigationContract
import com.example.game_page_domain.models.GenreUi
import com.example.game_page_domain.models.TagUi
import com.example.game_page_feature.databinding.GamePageFragmentBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamePageFragment : Fragment() {

    private lateinit var binding: GamePageFragmentBinding
    private lateinit var navigationContract: NavigationContract

    private val gameId: String
        get() = arguments?.getString(ARG_GAME_ID) ?: throw IllegalStateException()
    private val viewModel: GamePageViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationContract) {
            navigationContract = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGamePage(gameId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = GamePageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gamePageShimmerInclude.gamePageShimmer.startShimmer()

        viewModel.gamePage.observe(viewLifecycleOwner) {
            with(binding) {
                gamePageShimmerInclude.gamePageShimmer.apply {
                    stopShimmer()
                    visibility = View.GONE
                }
                gamePageDetail.visibility = View.VISIBLE

                it.pictureUrl?.let { url ->
                    loadPicture(url)
                    binding.gamePagePicture.setOnClickListener {
                        showPictureFullScreen(url)
                    }
                }

                it.platformUis?.let { platforms ->
                    gamePagePlatformView.initPlatformsView(
                        platformsPage = platforms, platforms = null
                    )
                }

                it.genres?.let { genres ->
                    setGameGenres(genres)
                } ?: let {
                    gameGenresTitle.visibility = View.GONE
                }

                it.name?.let { name ->
                    gameName.text = name
                }

                it.rating?.let { rating ->
                    gamePageRating.rating = rating.toFloat()
                }

                it.description?.takeIf { it.isNotEmpty() }?.let { description ->
                    gameDescription.text = setTextFromHtml(description)
                } ?: let {
                    gameRedditDescriptionTitle.visibility = View.GONE
                }

                it.tags?.takeIf { it.isNotEmpty() }?.let { tags ->
                    setGameTags(tags)
                } ?: let {
                    gameTagsTitle.visibility = View.GONE
                }

                it.reditDescription?.takeIf { it.isNotEmpty() }?.let { redditDescription ->
                    gameRedditDescription.text = redditDescription
                    it.reditLink?.let { reditLink ->
                        gameRedditDescriptionTitle.setOnClickListener {
                            openRedit(reditLink)
                        }
                    }
                } ?: let {
                    gameRedditDescriptionTitle.visibility = View.GONE
                }
            }
        }
    }

    private fun openRedit(reditLink: String) {
        // Check if reddit application was installed
        var intent = activity?.packageManager?.getLaunchIntentForPackage("reddit.inc")
        if (intent != null) {
            // Reddit is installed, open it
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        } else {
            // Reddit is not installed, open web browser
            intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(reditLink)
            }
        }
        startActivity(intent)
    }

    private fun setTextFromHtml(text: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(text)
        }
    }

    private fun loadPicture(pictureUrl: String) {
        val deviceWith = activity?.windowManager?.defaultDisplay?.width ?: 1080
        Picasso.get()
            .load(pictureUrl)
            .resize(deviceWith, 0) // Use 0 to preserve picture ratio
            .onlyScaleDown()
            .centerInside()
            .into(binding.gamePagePicture)
    }

    private fun showPictureFullScreen(url: String) {
        navigationContract.showPictureInFullScreen(url)
    }

    private fun setGameGenres(genres: List<GenreUi>) {
        genres.forEach { genre ->
            val myView = TextView(activity?.applicationContext).apply {
                text = genre.name
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(R.style.textDescription)
                }
            }
            binding.gameGenres.addView(myView)
        }
    }

    private fun setGameTags(tags: List<TagUi>) {
        tags.forEach { tag ->
            val myView = TextView(activity?.applicationContext).apply {
                text = tag.name
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(R.style.textDescription)
                }
            }
            binding.gameTags.addView(myView)
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