package com.gekss.sydykov_daniel_hw_5_month_3_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MainFragment : Fragment() {
    private var counter = 0
    private lateinit var btnPlusMinus: Button
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        btnPlusMinus = view.findViewById(R.id.btn_plus_minus)
        textView = view.findViewById(R.id.text_view)
        return view
    }

    private fun updateCounterText() {
        if (counter == 10) {
            btnPlusMinus.text = "-1"
        }
        textView.text = counter.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPlusMinus.setOnClickListener {
            if (btnPlusMinus.text == "+1") {
                if (counter < 10) {
                    counter++
                } else {
                    btnPlusMinus.text = "-1"
                }
            } else {
                if (counter > 0) {
                    counter--
                } else {
                    openSecondFragment()
                }
            }
            updateCounterText()
        }
    }

    private fun openSecondFragment() {
        val secondFragment = SecondFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}