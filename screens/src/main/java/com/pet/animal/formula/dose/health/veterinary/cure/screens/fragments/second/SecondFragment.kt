package com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.pet.animal.formula.dose.health.veterinary.cure.screens.databinding.FragmentSecondBinding
import com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.first.FirstFragmentViewModel
import com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator.AppScreensImpl
import org.koin.java.KoinJavaComponent

class SecondFragment: Fragment() {
    /** Задание переменных */ //region
    // Binding
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding
        get() {
            return _binding!!
        }
    private val screens: AppScreensImpl = KoinJavaComponent.getKoin().get()
    private val router: Router = KoinJavaComponent.getKoin().get()
    lateinit var buttonToFirstScreen: Button
    lateinit var buttonToThirdScreen: Button
    lateinit var model: ViewModel
    //endregion

    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        buttonToFirstScreen = binding.secondFragmentGotoFirstFragmentButton
        buttonToFirstScreen.setOnClickListener {
            router.navigateTo(screens.firstScreen())
        }
        buttonToThirdScreen = binding.secondFragmentGotoThirdFragmentButton
        buttonToThirdScreen.setOnClickListener {
            router.navigateTo(screens.thirdScreen())
        }

        model = ViewModelProvider(this).get(SecondFragmentViewModel::class.java)

        return binding.root
    }

    // Очистка Binding при уничтожении фрагмента
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    // Закрытие данного окна
}