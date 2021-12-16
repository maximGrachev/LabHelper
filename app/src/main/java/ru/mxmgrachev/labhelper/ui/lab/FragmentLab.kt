package ru.mxmgrachev.labhelper.ui.lab

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.mxmgrachev.labhelper.R
import ru.mxmgrachev.labhelper.data.database.LabDatabase
import ru.mxmgrachev.labhelper.databinding.FragmentLabBinding
import ru.mxmgrachev.labhelper.ui.dialog.DialogPhoto

class FragmentLab : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLabBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_lab, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = LabDatabase.getInstance(application).labDao
        val args = FragmentLabArgs.fromBundle(requireArguments())
        val labViewModelFactory = LabViewModelFactory(args.labId, dataSource)
        val labViewModel = ViewModelProvider(this, labViewModelFactory)
            .get(LabViewModel::class.java)
        binding.labViewModel = labViewModel
        binding.lifecycleOwner = this

        binding.imageStatus.setOnClickListener {
            val statusMap = mapOf(
                getText(R.string.is_not_complete) to "not_complete",
                getText(R.string.is_done) to "done",
                getText(R.string.is_all_done) to "all_done"
            )

            val statusNow = statusMap[binding.textLabStatus.text]

            when (statusNow) {
                "not_complete" -> {
                    binding.imageStatus.setImageResource(R.drawable.outline_done_24)
                    binding.textLabStatus.setText(R.string.is_done)
                }
                "done" -> {
                    binding.imageStatus.setImageResource(R.drawable.outline_done_all_24)
                    binding.textLabStatus.setText(R.string.is_all_done)
                }
                "all_done" -> {
                    binding.imageStatus.setImageResource(R.drawable.outline_close_24)
                    binding.textLabStatus.setText(R.string.is_not_complete)
                }
                else -> {
                    binding.imageStatus.setImageResource(R.drawable.outline_close_24)
                    binding.textLabStatus.setText(R.string.is_not_complete)
                }
            }
        }

        //Show save button
        binding.editTextSubject.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                showAddButton(binding)
            }
        })

        binding.editTextLabNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                showAddButton(binding)
            }
        })

        binding.editTextLabQuestion.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                showAddButton(binding)
            }
        });

        binding.editTextLabMainText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                showAddButton(binding)
            }
        });

        val labNumber: Int? = if(binding.editTextLabNumber.text.isNotBlank() && binding.editTextLabNumber.text.isNotEmpty()){
            binding.editTextLabNumber.text.toString().toInt()
        }
        else null
        binding.buttonSave.setOnClickListener {
            if (binding.editTextSubject.text.isNotBlank() && binding.editTextSubject.text.isNotEmpty()) {
                labViewModel.createNewLab(
                    binding.editTextSubject.text.toString(),
                    labNumber,
                    binding.editTextLabQuestion.text?.toString(),
                    binding.textLabStatus.text.toString(),
                    binding.editTextLabMainText?.text.toString(),
                )
                findNavController().navigate(FragmentLabDirections.actionLabFragmentToMainFragment())
            } else {
                Toast.makeText(context, "Заполните поле \"Предмет\"", Toast.LENGTH_SHORT).show()
            }
        }

        //Dialog
        val dialogPhoto: DialogPhoto = DialogPhoto()

        binding.buttonTable.setOnClickListener {
            findNavController().navigate(FragmentLabDirections.actionLabFragmentToTableFragment())
        }
        binding.buttonPhoto.setOnClickListener {
            fragmentManager?.let { it1 -> dialogPhoto.show(it1, "photoDialog") }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showAddButton(binding: FragmentLabBinding) {
        if (binding.editTextLabMainText.text.isNotBlank() ||
            binding.editTextLabNumber.text.isNotBlank() ||
            binding.editTextLabQuestion.text.isNotBlank() ||
            binding.editTextSubject.text.isNotBlank()
        ) {
            binding.buttonSave.visibility = View.VISIBLE
        } else {
            binding.buttonSave.visibility = View.GONE
        }
    }
}