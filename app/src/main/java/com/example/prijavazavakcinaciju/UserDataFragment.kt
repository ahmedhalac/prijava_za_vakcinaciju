package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prijavazavakcinaciju.databinding.FragmentUserDataBinding


class UserDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUserDataBinding>(inflater, R.layout.fragment_user_data, container, false)

        binding.userDataBtn.setOnClickListener{ view: View ->
            val firstName = binding.ime.text.toString()
            val lastName = binding.prezime.text.toString()
            val ages = binding.godine.text.toString()
            val phone = binding.telefon.text.toString()
            val email = binding.email.text.toString()



            // Validation
            if(firstName == "" || lastName == "" || ages == "" || phone == "" || email == "") {
                Toast.makeText(activity, "Popunite sva polja!", Toast.LENGTH_SHORT).show()
            }else {
                view.findNavController().navigate(UserDataFragmentDirections.actionUserDataFragmentToPriorityGroupFragment(firstName, lastName, ages, phone, email))
            }

        }

        return binding.root
    }

}