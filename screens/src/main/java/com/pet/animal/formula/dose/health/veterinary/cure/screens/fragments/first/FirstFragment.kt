package com.pet.animal.formula.dose.health.veterinary.cure.screens.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.pet.animal.formula.dose.health.veterinary.cure.screens.databinding.FragmentFirstBinding
import com.pet.animal.formula.dose.health.veterinary.cure.screens.navigator.AppScreensImpl
import org.koin.java.KoinJavaComponent

class FirstFragment: Fragment() {
    /** Задание переменных */ //region
        // Binding
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() {
            return _binding!!
        }
    private val screens: AppScreensImpl = KoinJavaComponent.getKoin().get()
    private val router: Router = KoinJavaComponent.getKoin().get()
    lateinit var buttonToMainActivityScreen: Button
    lateinit var buttonToSecondScreen: Button
    lateinit var model: ViewModel
    //endregion

    companion object {
        fun newInstance(): FirstFragment = FirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        buttonToMainActivityScreen = binding.firstFragmentGotoMainAcitivyButton
        buttonToMainActivityScreen.setOnClickListener {
            router.exit()
        }
        buttonToSecondScreen = binding.firstFragmentGotoSecondFragmentButton
        buttonToSecondScreen.setOnClickListener {
            router.navigateTo(screens.secondScreen())
        }

        model = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)

        return binding.root
    }

    // Очистка Binding при уничтожении фрагмента
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}