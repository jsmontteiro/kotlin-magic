package features.cards.di

import features.cards.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val uiModule = module{
    viewModel { MainViewModel(listCardsUseCase = get()) }
}