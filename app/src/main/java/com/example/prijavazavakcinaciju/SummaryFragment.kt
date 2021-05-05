package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.prijavazavakcinaciju.databinding.FragmentSummaryBinding
import com.example.prijavazavakcinaciju.databinding.FragmentUserDataBinding

class SummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = SummaryFragmentArgs.fromBundle(requireArguments())
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSummaryBinding>(inflater, R.layout.fragment_summary, container, false)

        binding.tvFirstName.text = args.firstName
        binding.tvLastName.text = args.lastName
        return binding.root
    }

}