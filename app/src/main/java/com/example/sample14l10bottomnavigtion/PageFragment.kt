package com.example.sample14l10bottomnavigtion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.sample14l10bottomnavigtion.databinding.FragmentPageBinding

class PageFragment : Fragment() {

    private var _binding: FragmentPageBinding? = null
    private val binding get() = requireNotNull(_binding)
//    private var pageText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPageBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val nestedController =
                (childFragmentManager.findFragmentById(R.id.fragment_page) as NavHostFragment)
                    .navController
            bottomNavigation.setupWithNavController(nestedController)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}