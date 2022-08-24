package br.com.montteiro.kotlinpokedex

import android.app.Application
import br.com.montteiro.pokedex.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KotlinPokedexApplication() : Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@KotlinPokedexApplication)
            modules(AppModule.getModules())
        }
    }

}