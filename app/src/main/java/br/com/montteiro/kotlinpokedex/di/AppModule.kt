package br.com.montteiro.pokedex.di

import features.pokedex.di.PokedexModule

object AppModule {
    fun getModules() = listOf(
        *PokedexModule.getModules()
    )
}