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
        val binding = DataBindingUtil.inflate<FragmentPriorityGroupBinding>(
            inflater,
            R.layout.fragment_priority_group,
            container,
            false
        )

        val args = PriorityGroupFragmentArgs.fromBundle(requireArguments())

        //na pocetku postavljeno na prvi odgovor ako se ne klikne nista
        var priority = "Prioritetna grupa (" + binding.answer1.text.toString() + ")"

        binding.radioGroupPriority.setOnCheckedChangeListener{ _, checkedId ->
            if(checkedId == binding.answer1.id) {
                priority = "Prioritetna grupa (" + binding.answer1.text.toString() + ")"
            }else if(checkedId == binding.answer2.id) {
                priority = "Prioritetna grupa (" + binding.answer2.text.toString() + ")"
            }
            else if(checkedId == binding.answer3.id) {
                priority = "Prioritetna grupa (" + binding.answer3.text.toString() + ")"
            }else {
                priority = "Nije u prioritetnoj grupi"
            }
        }


        binding.priorityGroupBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(
                PriorityGroupFragmentDirections.actionPriorityGroupFragmentToVaccinesFragment2(
                    args.firstName,
                    args.lastName,
                    args.age,
                    args.phone,
                    args.email,
                    priority
                )
            )
        }

        return binding.root
    }


}