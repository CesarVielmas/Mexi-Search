package com.example.principalApp

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView

class ModalWindowConfirm(private val onActionSelect: (Boolean) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.modal_window_confirm, null)
        val buttonCancel : Button = view.findViewById(R.id.dialogButtonCancel)
        val buttonConfirm : Button = view.findViewById(R.id.dialogButtonConfirm)
        buttonCancel.setOnClickListener{
            onActionSelect(false)
            dismiss()
        }
        buttonConfirm.setOnClickListener{
            onActionSelect(true)
            dismiss()
        }
        builder.setView(view)
        return builder.create()
    }
}
