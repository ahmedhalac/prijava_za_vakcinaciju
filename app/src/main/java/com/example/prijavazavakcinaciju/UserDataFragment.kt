package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.prijavazavakcinaciju.databinding.FragmentUserDataBinding


class UserDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUserDataBinding>(inflater, R.layout.fragment_user_data, container, false)

        binding.userDataBtn.setOnClickListener{
            Toast.makeText(activity, "ok", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}