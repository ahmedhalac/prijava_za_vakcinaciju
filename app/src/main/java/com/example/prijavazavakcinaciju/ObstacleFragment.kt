package com.example.prijavazavakcinaciju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.example.prijavazavakcinaciju.databinding.FragmentObstacleBinding

class ObstacleFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
    )


    //Prvi odgovor je jedini ispravan za nastavak kroz prijavu
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "Da li postoje prepreke za primanje vakcine?",
            answers = listOf("Nemam prepreka za vakcinaciju", "Trenutno bolujem od Covid-19", "Trudnoća")
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentObstacleBinding>(
            inflater,
            R.layout.fragment_obstacle,
            container,
            false
        )

        setQuestion()

        // Bind this fragment class to the layout
        binding.obstacle = this

        // Set the onClickListener for the  submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing  is clicked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                }

                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    view.findNavController().navigate(R.id.action_obstacleFragment_to_userDataFragment)
                } else {
                    //Neuspjela prijava
                    view.findNavController().navigate(R.id.action_obstacleFragment_to_canceledFragment)
                }
            }
        }

        return binding.root
    }


    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()

    }

}