package ru.mxmgrachev.labhelper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.loader.app.LoaderManager
import androidx.navigation.fragment.findNavController
import ru.mxmgrachev.labhelper.databinding.FragmentLabBinding

class FragmentLab : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLabBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_lab, container, false)

        //Dialog
        val dialogPhoto: DialogPhoto = DialogPhoto()


        binding.buttonTable.setOnClickListener{
            findNavController().navigate(FragmentLabDirections.actionLabFragmentToTableFragment())
        }
        binding.buttonPhoto.setOnClickListener{
            fragmentManager?.let { it1 -> dialogPhoto.show(it1, "photoDialog") }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}