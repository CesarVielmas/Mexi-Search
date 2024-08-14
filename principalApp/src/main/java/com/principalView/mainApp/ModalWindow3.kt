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

class ModalWindow3 : DialogFragment() {
    private var isEmpty: Boolean = false
    fun setVariable(isEmpty: Boolean) {
        this.isEmpty = isEmpty
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.modal_window_third, null)
        val buttonClose: Button = view.findViewById(R.id.dialogButton)
        val imageView : ImageView = view.findViewById(R.id.dialogImage)
        val textWarn : TextView = view.findViewById(R.id.dialogWarn)
        if(isEmpty){
            imageView.setImageResource(R.mipmap.error_modal)
            textWarn.text = getString(R.string.modal_view_text_third_part_one)
        }
        else{
            imageView.setImageResource(R.mipmap.error_modal_two)
            textWarn.text = getString(R.string.modal_view_text_third_part_two)
        }
        buttonClose.setOnClickListener {
            dismiss()
        }
        builder.setView(view)
        return builder.create()
    }
}
