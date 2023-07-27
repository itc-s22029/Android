package jp.ac.it_college.std.s22029.listviewsample

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class OrderConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =

        AlertDialog.Builder(requireActivity())
            .setTitle("注文確認")
            .setMessage("選択された定食を注文します。よろしいですか。")
            .setPositiveButton("注文", dialogButtonClickListener)
            .setNegativeButton("キャンセル", dialogButtonClickListener)
            .setNeutralButton("問い合わせ", dialogButtonClickListener)
            .create()

    private val dialogButtonClickListener =
        DialogInterface.OnClickListener{_, which ->
            val msg = when(which) {
                DialogInterface.BUTTON_POSITIVE -> "ご注文ありがとうございます。"
                DialogInterface.BUTTON_NEGATIVE -> "ご注文をキャンセルしました"
                DialogInterface.BUTTON_NEUTRAL -> "お問い合わせ内容をお知らせください"
                else -> "ご注文をキャンセルしました"
            }
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
}