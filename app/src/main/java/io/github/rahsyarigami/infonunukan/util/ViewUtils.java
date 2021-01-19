package io.github.rahsyarigami.infonunukan.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import io.github.rahsyarigami.infonunukan.R;

public class ViewUtils {

    public static void fragmentTransition(FragmentManager fragmentManager, Fragment fragmentPosition, Fragment currentFragment, String tag) {
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction().add(R.id.frame_container, fragmentPosition, tag).hide(currentFragment).commit();
        } else {
            if (!fragmentManager.findFragmentByTag(tag).isVisible()) {
                fragmentManager.beginTransaction().hide(currentFragment).show(fragmentPosition).commit();
            }
        }

    }

    public static int getRandomGeneratorColor(String typeColor, Context context) {
        int returnColor = Color.GRAY;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }

        return returnColor;
    }

    public static void copyNumber(String text, String name, Context context) {
        String label = "";
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(label, text);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context, "Nomor kontak " + name + " berhasil disalin", Toast.LENGTH_SHORT).show();
        }
    }

}
