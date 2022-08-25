package br.com.montteiro.kotlinmagic

import android.app.Application
import br.com.montteiro.kotlinmagic.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KotlinMagicApplication() : Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@KotlinMagicApplication)
            modules(AppModule.getModules())
        }
    }
}