package io.github.rahsyarigami.infonunukan.util;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class DialogUtils {

    private static boolean alerted = false;

    public static void showConfirm(Context context, String message, DialogInterface.OnClickListener actionPositive, DialogInterface.OnClickListener actionNegative) {
        if (context == null && alerted) {
            return;
        }

        alerted = true;

        assert context != null;
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Tidak", (dialog, which) -> {
            alerted = false;
            dialog.dismiss();
            if (actionNegative != null) {
                actionNegative.onClick(dialog, which);
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ya", (dialog, which) -> {
            alerted = false;
            dialog.dismiss();
            if (actionPositive != null) {
                actionPositive.onClick(dialog, which);
            }
        });

        alertDialog.show();
    }

}
