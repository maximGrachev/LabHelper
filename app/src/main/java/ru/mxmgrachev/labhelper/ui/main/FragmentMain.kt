package ru.mxmgrachev.labhelper.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import ru.mxmgrachev.labhelper.R
import ru.mxmgrachev.labhelper.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.buttonAdd.setOnClickListener{
            findNavController().navigate(FragmentMainDirections.actionMainFragmentToLabFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}