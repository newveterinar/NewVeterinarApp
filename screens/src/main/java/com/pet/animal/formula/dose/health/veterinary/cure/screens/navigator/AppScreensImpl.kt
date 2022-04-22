package com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.first.FirstFragment
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.second.SecondFragment
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.third.ThirdFragment

class AppScreensImpl: AppScreens {
    override fun firstScreen() = FragmentScreen {
        FirstFragment.newInstance()
    }

    override fun secondScreen() = FragmentScreen {
        SecondFragment.newInstance()
    }

    override fun thirdScreen() = FragmentScreen {
        ThirdFragment.newInstance()
    }
}