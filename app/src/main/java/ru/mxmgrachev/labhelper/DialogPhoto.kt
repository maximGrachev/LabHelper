package ru.mxmgrachev.labhelper

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import ru.mxmgrachev.labhelper.databinding.DialogPhotoBinding


class DialogPhoto : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.border_dialog_round);
        val binding: DialogPhotoBinding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_photo, container, false)

        binding.buttonDialogCancel.setOnClickListener {
            dialog?.cancel()
        }

        binding.textCamera.setOnClickListener {
            takePicFromCamera()
            dialog?.cancel()
        }
        binding.imageCamera.setOnClickListener {
            takePicFromCamera()
            dialog?.cancel()
        }

        binding.textGallery.setOnClickListener {
            getPicFromGallary()
            dialog?.cancel()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun takePicFromCamera() {
        val REQUEST_IMAGE_CAPTURE = 1
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    private fun getPicFromGallary(){
        val PICK_IMAGE = 1
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
    }
}
