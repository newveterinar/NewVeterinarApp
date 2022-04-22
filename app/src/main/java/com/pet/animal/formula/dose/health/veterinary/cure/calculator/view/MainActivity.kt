package com.pet.animal.formula.dose.health.veterinary.cure.calculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.pet.animal.formula.dose.health.veterinary.cure.calculator.R
import com.pet.animal.formula.dose.health.veterinary.cure.calculator.app.app
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.first.FirstFragmentViewModel
import com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator.AppScreensImpl
import com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator.BackButtonListener
import com.pet.animal.formula.dose.health.veterinary.cure.utils.Constants
import org.koin.core.Koin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin

class MainActivity: AppCompatActivity() {
    /** Задание переменных */ //region
    private val navigator = AppNavigator(this@MainActivity, R.id.activity_fragments_container)
    private val screens: AppScreensImpl = getKoin().get()
    private val router: Router = getKoin().get()
    private val navigatorHolder: NavigatorHolder = getKoin().get()
    private val mainActivityScope: Scope = getKoin().getOrCreateScope(
        Constants.MAIN_ACTIVITY_NAME, named(Constants.MAIN_ACTIVITY_NAME)
    )
    lateinit var model: ViewModel
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by mainActivityScope.inject()
        model = viewModel
//        model = ViewModelProvider(this).get(MainViewModel::class.java)

        // Это работает
//        app.instance!!.router.exit()
//        app.instance!!.router.navigateTo(screens.firstScreen())
        if (savedInstanceState == null) {
            router.navigateTo(screens.firstScreen())
        }
    }

    override fun onResume() {
        super.onResume()
//        app.instance?.let {
//            it.navigatorHolder.setNavigator(navigator)
//        }
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
//        app.instance?.let {
//            it.navigatorHolder.removeNavigator()
//        }
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
//        app.instance!!.router.exit()
        router.exit()
    }
    //endregion

    override fun onDestroy() {
        // Удаление скоупа для данной активити
        mainActivityScope.close()
        super.onDestroy()
    }
}