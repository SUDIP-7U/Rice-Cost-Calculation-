package com.example.newapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newapplication.RiceViewModel
import com.example.newapplication.databinding.FragmentRiceBinding


class RiceFragment : Fragment() {

    private var _binding: FragmentRiceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RiceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Set initial daily cost
        viewModel.calculateDailyCost()
        viewModel.dailyCost.observe(viewLifecycleOwner) { (miniCatDaily, normalDaily) ->
            binding.tvMiniCat.text = "MiniCat: ${miniCatDaily} Tk per day"
            binding.tvNormal.text = "Normal: ${normalDaily} Tk per day"
        }

        // Submit button click

        binding.btnSubmit.setOnClickListener {

            val days = binding.etDays.text.toString().toIntOrNull() ?: 0

            // Calculate total kg and cost

            val miniCatKg = 0.5 * days

            val normalKg = 0.5 * days

            val (miniCatTotal, normalTotal) = viewModel.calculateCostForDays(days)

            // Update UI
            binding.tvMiniCat.text = "MiniCat: ${miniCatKg} kg → ${miniCatTotal} Tk"
            binding.tvNormal.text = "Normal: ${normalKg} kg → ${normalTotal} Tk"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
