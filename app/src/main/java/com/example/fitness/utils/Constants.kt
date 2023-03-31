package com.example.fitness.utils

import android.app.Dialog
import android.content.Context

object Constants {

    lateinit var dialog: Dialog
    fun showCustomAlertDialog(
        context: Context,
        layout: Int,
        checkCancel: Boolean,
    ) {
        dialog = Dialog(context)
        dialog.setContentView(layout)
        dialog.setCancelable(checkCancel)
        dialog.show()
    }
    fun hideCustomAlertDialog() {
        dialog.cancel()
    }
}