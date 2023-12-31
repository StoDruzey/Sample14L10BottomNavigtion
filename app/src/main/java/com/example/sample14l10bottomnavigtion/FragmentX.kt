package com.example.sample14l10bottomnavigtion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sample14l10bottomnavigtion.databinding.FragmentxBinding
import kotlin.random.Random

class FragmentX : Fragment() {

    private var _binding: FragmentxBinding? = null
    private val binding get() = requireNotNull(_binding)
    private var fragmentText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentText = savedInstanceState?.getString(PAGE_KEY) ?: "Page: ${Random.nextInt(0, 20)}"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentxBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pageText.text = fragmentText
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(PAGE_KEY, fragmentText)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        fragmentText = binding.pageText.text.toString()
        _binding = null
    }

    companion object {
        private const val PAGE_KEY = "page_key"
    }
}