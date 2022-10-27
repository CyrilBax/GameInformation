package com.example.game_list_feature.ui.main

import androidx.lifecycle.ViewModel
import com.example.game_list_domain.usecases.GetGameListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGameListUseCase: GetGameListUseCase
) : ViewModel() {
    val text = "main fragment"
}