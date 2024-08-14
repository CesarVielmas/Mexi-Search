package com.example.principalApp

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.widget.Button

class ModalWindow2 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.modal_window_second, null)
        val buttonClose: Button = view.findViewById(R.id.dialogButton)
        buttonClose.setOnClickListener {
            dismiss()
        }
        builder.setView(view)
        return builder.create()
    }
}
