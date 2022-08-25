package br.com.montteiro.kotlinmagic.di

import features.cards.di.CardsModule

object AppModule {
    fun getModules() = listOf(
        *CardsModule.getModules()
    )
}