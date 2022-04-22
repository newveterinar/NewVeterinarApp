package com.pet.animal.formula.dose.health.veterinary.cure.calculator.app

import android.app.Application
import com.pet.animal.formula.dose.health.veterinary.cure.calculator.di.screens
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class app: Application() {
    /** Задание переменных */ //region
//    private var cicerone: Cicerone<Router>? = null
    //endregion

    override fun onCreate() {
        super.onCreate()
        instance = this
//        cicerone = Cicerone.create()

        // Koin
        startKoin {
            androidContext(applicationContext)
            modules(listOf(screens))
        }
    }

//    val navigatorHolder: NavigatorHolder
//        get() = cicerone!!.getNavigatorHolder()
//    val router: Router
//        get() = cicerone!!.router

    companion object {
        var instance: app? = null
    }
}