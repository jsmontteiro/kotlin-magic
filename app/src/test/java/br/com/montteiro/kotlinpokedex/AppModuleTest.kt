package br.com.montteiro.kotlinpokedex

import br.com.montteiro.kotlinmagic.di.AppModule
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

internal class AppModuleTest : KoinTest {
    @Test
    fun `check module`() {
        koinApplication {
            modules(AppModule.getModules())
        }.checkModules()
    }
}