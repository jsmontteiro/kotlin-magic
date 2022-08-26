package features.cards.di

import features.cards.usecase.ListCardsUseCase
import org.koin.dsl.module

internal val useCaseModule  = module {
    factory { ListCardsUseCase(repo = get()) }
}