package com.example.lab_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BlankFragment : Fragment() {
    private lateinit var sharedViewModel: MainActivity.SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(MainActivity.SharedViewModel::class.java)

        view.findViewById<Button>(R.id.button_send).setOnClickListener {
            val data = "Прилёт с ПЕРВОГО фрагмента"
            sharedViewModel.setData(data)
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()

    }
}