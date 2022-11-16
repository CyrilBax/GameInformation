package com.example.game_list_feature.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_list_domain.models.GameLightUi
import com.example.game_list_domain.usecases.GetGameListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGameListUseCase: GetGameListUseCase
) : ViewModel() {

    val gameList: LiveData<List<GameLightUi>>
        get() = _gameList
    val error: LiveData<Unit>
        get() = _error

    private val _gameList: MutableLiveData<List<GameLightUi>> = MutableLiveData()
    private val _error: MutableLiveData<Unit> = MutableLiveData()
    private var _page: Int = 1

    fun getGameList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getGameListUseCase.execute(_page)
                _page++
                _gameList.postValue(result.gameLights)
            } catch (e: Exception) {
                Timber.e(e)
                _error.postValue(Unit)
            }
        }

    }
}