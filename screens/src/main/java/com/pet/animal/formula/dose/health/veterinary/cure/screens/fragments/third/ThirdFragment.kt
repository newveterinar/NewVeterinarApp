package com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.pet.animal.formula.dose.health.veterinary.cure.screens.databinding.FragmentThirdBinding
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.second.SecondFragmentViewModel
import com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator.AppScreensImpl
import org.koin.java.KoinJavaComponent

class ThirdFragment: Fragment() {
    /** Задание переменных */ //region
    // Binding
    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding
        get() {
            return _binding!!
        }
    private val screens: AppScreensImpl = KoinJavaComponent.getKoin().get()
    private val router: Router = KoinJavaComponent.getKoin().get()
    lateinit var buttonToSecondScreen: Button
    lateinit var model: ViewModel
    //endregion

    companion object {
        fun newInstance(): ThirdFragment = ThirdFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        buttonToSecondScreen = binding.thirdFragmentGotoSecondFragmentButton
        buttonToSecondScreen.setOnClickListener {
            router.navigateTo(screens.secondScreen())
        }

        model = ViewModelProvider(this).get(ThirdFragmentViewModel::class.java)

        return binding.root
    }

    // Очистка Binding при уничтожении фрагмента
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}