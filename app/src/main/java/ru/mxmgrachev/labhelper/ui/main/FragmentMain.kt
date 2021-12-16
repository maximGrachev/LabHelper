package ru.mxmgrachev.labhelper.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mxmgrachev.labhelper.R
import ru.mxmgrachev.labhelper.data.database.LabDatabase
import ru.mxmgrachev.labhelper.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(FragmentMainDirections.actionMainFragmentToLabFragment())
        }

        val application = requireNotNull(this.activity).application
        val labDatabase = LabDatabase.getInstance(application).labDao

        //viewModel
//        val viewModelFactory = MainViewModelFactory(labDatabase)
//
//        val viewModel =
//            ViewModelProvider(
//                this, viewModelFactory).get(MainViewModel::class.java)


        //AllLab Recycler View
//        val adapter = MainAdapter(LabListener {
//                labId ->  viewModel.onLabClicked(labId)
//        })
//        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        binding.listAllLab.layoutManager = manager
//        binding.lifecycleOwner = this
//        binding.listAllLab.adapter = adapter
//
//        viewModel.navigateToLab.observe(viewLifecycleOwner, Observer { lab ->
//            lab?.let {
//                this.findNavController().navigate(
//                    FragmentMainDirections
//                        .actionMainFragmentToLabFragment())
//                viewModel.onLabFragmentNavigated()
//            }
//        })
//
//        viewModel.labList.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                adapter.submitList(it)
//            }
//        })

        // Inflate the layout for this fragment
        return binding.root
    }
}