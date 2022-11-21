package com.example.game_list_feature.ui.main

import com.example.business.contracts.NavigationContract
import dagger.Module
import dagger.Provides

@Module
class GameListModule {
    @Provides
    fun provideNavigationContract(fragment: GameListFragment): NavigationContract =
        fragment.activity as NavigationContract
}