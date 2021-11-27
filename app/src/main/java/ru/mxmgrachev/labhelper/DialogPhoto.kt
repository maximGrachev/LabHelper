package ru.mxmgrachev.labhelper

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import ru.mxmgrachev.labhelper.databinding.DialogPhotoBinding

class DialogPhoto : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
//            val binding: DialogPhotoBinding =
//                DataBindingUtil.inflate(inflater, R.layout.dialog_photo, container false)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_photo, null))
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}