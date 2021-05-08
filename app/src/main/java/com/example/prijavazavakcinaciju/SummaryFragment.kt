package com.example.prijavazavakcinaciju

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prijavazavakcinaciju.databinding.FragmentSummaryBinding
import com.example.prijavazavakcinaciju.databinding.FragmentUserDataBinding

class SummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = SummaryFragmentArgs.fromBundle(requireArguments())
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSummaryBinding>(
            inflater,
            R.layout.fragment_summary,
            container,
            false
        )

        binding.tvFirstLastName.text =
            getString(R.string.first_last_name_text, args.firstName, args.lastName)
        binding.tvAge.text = args.age
        binding.tvPhone.text = args.phone
        binding.tvEmail.text = args.email
        binding.tvPriority.text = args.priority
        binding.tvVaccine.text = args.vaccine

        binding.termLocationBtn.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_summaryFragment_to_appointmentFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent(): Intent {
        val args = SummaryFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(
                    R.string.share_text,
                    args.firstName,
                    args.lastName,
                    args.age,
                    args.phone,
                    args.email,
                    args.priority,
                    args.vaccine
                )
            )
        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.summary_menu, menu)
        // Da li postoji aktivnost na mobilnom uredjaju koja moze poslati tekstualnu poruku
        if (getShareIntent().resolveActivity(requireActivity().packageManager) == null) {
            menu.findItem(R.id.share).isVisible = false
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}