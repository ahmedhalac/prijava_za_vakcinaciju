package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prijavazavakcinaciju.databinding.FragmentVaccinesBinding


class VaccinesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentVaccinesBinding>(
            inflater,
            R.layout.fragment_vaccines,
            container,
            false
        )

        val args = VaccinesFragmentArgs.fromBundle(requireArguments())

        var vaccine = ""

        binding.vaccineRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == binding.idVaccinesRadio1.id) {
                vaccine = binding.idVaccinesRadio1.text.toString()
            } else if (checkedId == binding.idVaccinesRadio2.id) {
                vaccine = binding.idVaccinesRadio2.text.toString()
            } else if (checkedId == binding.idVaccinesRadio3.id) {
                vaccine = binding.idVaccinesRadio3.text.toString()
            } else {
                vaccine = binding.idVaccinesRadio3.text.toString()
            }
        }


        binding.vaccinesBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(
                VaccinesFragmentDirections.actionVaccinesFragment2ToSummaryFragment(
                    args.firstName,
                    args.lastName,
                    args.age,
                    args.phone,
                    args.email,
                    args.priority,
                    vaccine
                )
            )
        }



        return binding.root
    }


}