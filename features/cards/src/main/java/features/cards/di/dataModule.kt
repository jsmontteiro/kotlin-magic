package features.cards.di

import features.cards.data.CardsRepository
import features.cards.data.network.CardsApi
import features.cards.data.network.CardsNetworkRepository
import libraries.network.ApiClientBuilder
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule  = module {
    single { ApiClientBuilder.createServiceApi(CardsApi::class.java) }
    factory { CardsNetworkRepository(api = get()) } bind CardsRepository::class
}