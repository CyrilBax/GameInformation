package com.example.game_page_feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_page_domain.models.GamePageModelUi
import com.example.game_page_domain.usecases.GetGamePageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamePageViewModel @Inject constructor(
    private val getGamePageUseCase: GetGamePageUseCase
) : ViewModel() {

    val gamePage: LiveData<GamePageModelUi>
        get() = _gamePage

    private val _gamePage: MutableLiveData<GamePageModelUi> = MutableLiveData()

    fun getGamePage(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val game = getGamePageUseCase.execute(gameId)
            _gamePage.postValue(game)
        }
    }

}