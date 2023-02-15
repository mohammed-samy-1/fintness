package com.example.fitness.constants

import android.app.Dialog
import android.content.Context


class Constants {
    companion object {
        fun String.validateEmail(): Boolean {
            return if (this.isEmpty()) {
                false
            } else {
                android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
            }
        }

        fun String.validatePass(): Boolean {
            return !(this.isEmpty() || this.length < 6)
        }

        fun String.validateFirstname(): Boolean {
            return !(this.isEmpty() || this.length < 3)
        }

        fun String.validateLastname(): Boolean {
            return !(this.isEmpty() || this.length < 4)
        }

//        fun customToast(context: Context, activity: Activity, msg: String) {
//            val inflater: LayoutInflater = activity.layoutInflater
//            val layout: View = inflater.inflate(
//                R.layout.customtoast,
//                activity.findViewById(R.id.toast_layout_root)
//            ) as ViewGroup
//
//            val text: TextView = layout.findViewById(R.id.txt_msg);
//            text.text = msg
//
//            val toast = Toast(context)
//            toast.duration = Toast.LENGTH_LONG
//            toast.view = layout
//            toast.show()
//        }

//        val Context.dataStore: DataStore<Preferences> by preferencesDataStore("save")
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
}