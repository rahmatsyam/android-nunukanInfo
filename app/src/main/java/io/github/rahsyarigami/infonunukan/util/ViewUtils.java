package io.github.rahsyarigami.infonunukan.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import io.github.rahsyarigami.infonunukan.R;

public class ViewUtils {

    public static void fragmentTransition(FragmentManager fragmentManager, Fragment fragmentPosition, Fragment currentFragment, String tag){
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction().add(R.id.frame_container, fragmentPosition,tag).hide(currentFragment).commit();
        } else {
            if (!fragmentManager.findFragmentByTag(tag).isVisible()) {
                fragmentManager.beginTransaction().hide(currentFragment).show(fragmentPosition).commit();
            }
        }

    }
}
