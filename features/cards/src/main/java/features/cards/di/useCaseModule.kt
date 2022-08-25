package features.cards.di

import features.cards.usecase.ListCardUseCase
import org.koin.dsl.module

internal val useCaseModule  = module {
    factory { ListCardUseCase(repo = get()) }
}