package com.example.prijavazavakcinaciju

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.prijavazavakcinaciju.databinding.FragmentAppointmentBinding
import timber.log.Timber
import java.net.HttpCookie.parse
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


const val KEY_REGISTERED_NUM = "timer_registered_num"

class AppointmentFragment : Fragment() {
    var registered : Int = 35200
    abstract class CountUpTimer protected constructor(private val duration: Long) : CountDownTimer(duration, INTERVAL_MS) {
        abstract fun onTick(second: Int)
        override fun onTick(msUntilFinished: Long) {
            val second = ((duration - msUntilFinished) / 1000).toInt()
            onTick(second)
        }

        override fun onFinish() {
            onTick(duration / 1000)
        }

        companion object {
            private const val INTERVAL_MS: Long = 1000
        }
    }
    private lateinit var vaccineAppTimer: VaccineAppTimer
    @SuppressLint("SimpleDateFormat")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAppointmentBinding>(inflater, R.layout.fragment_appointment, container, false)
        val args = AppointmentFragmentArgs.fromBundle(requireArguments())
        vaccineAppTimer = VaccineAppTimer(this.lifecycle)

        if(savedInstanceState != null) {
            vaccineAppTimer.registrationNumCount = savedInstanceState.getInt(KEY_REGISTERED_NUM, 53000)
        }
        

        // Get current date and increase it by 7
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val c = Calendar.getInstance()
        if(args.priority === "Nije u prioritetnoj grupi") {
            c.add(Calendar.DATE, 7)
        }else {
            c.add(Calendar.DATE, 2)
        }

        val currentDate = sdf.format(c.time)
        binding.tvTerm.text = currentDate.toString()


        val timer: CountUpTimer = object : CountUpTimer(300000) {
            override fun onTick(second: Int) {
                if(second % 5 == 0) {
                    val r = Random.nextInt(0,4)
                    registered += r
                    binding.tvRegisteredNum.text = registered.toString()
                }
            }
        }
        timer.start()

        Timber.i("onCreateView Called")
        return binding.root
    }

    // Called when the fragment is associated with its owner activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach Called")
    }

    // Similarly to onCreate() for the activity, onCreate() for the fragment is called to do initial fragment creation (other than layout).
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
    }

    // Called immediately after onCreateView() has returned, but before any saved state has been restored into the view.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated called")
    }

    // Called when the fragment becomes visible; parallel to the activity's onStart().
    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    // Called when the fragment gains the user focus; parallel to the activity's onResume()
    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    // Called when the fragment loses the user focus; parallel to the activity's onPause()
    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    // Called when the fragment is no longer visible on screen; parallel to the activity's onStop()
    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceCalled")
        outState.putInt(KEY_REGISTERED_NUM, vaccineAppTimer.registrationNumCount)
    }

    // Called when the fragment's view is no longer needed, to clean up the resources associated with that view.
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach called")
    }


}