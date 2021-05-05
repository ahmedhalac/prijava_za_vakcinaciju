package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prijavazavakcinaciju.databinding.FragmentPriorityGroupBinding

class PriorityGroupFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPriorityGroupBinding>(inflater, R.layout.fragment_priority_group, container, false)


        val args = PriorityGroupFragmentArgs.fromBundle(requireArguments())

        binding.priorityGroupBtn.setOnClickListener{ view: View ->
            view.findNavController().navigate(PriorityGroupFragmentDirections.actionPriorityGroupFragmentToVaccinesFragment2(args.firstName, args.lastName))
        }




        return binding.root
    }

}