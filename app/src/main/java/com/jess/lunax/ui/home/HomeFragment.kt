package com.jess.lunax.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.slider.Slider
import com.jess.lunax.R
import com.jess.lunax.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewmodel.getDataFromDate(0)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.slider.apply {
            valueFrom = -7f
            stepSize=1f
            valueTo = 7f
        }
        viewmodel.todayMoon.observe(viewLifecycleOwner) {
            binding.tvPhase.text = it.moonData.phase
            binding.tvAge.text = "Dias de edad     ${it.moonData.daysOld}"
            binding.ivMoon.setImageResource(it.moonData.photo)
            binding.tvDate.text = "${it.dayDataCalendar.weekDay}, ${it.dayDataCalendar.month} ${it.dayDataCalendar.dayOfMonth} ${it.dayDataCalendar.year}"
        }
        binding.slider.addOnChangeListener { slider, value, fromUser ->
           viewmodel.getDataFromDate(value.toInt())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}