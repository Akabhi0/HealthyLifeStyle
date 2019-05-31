package com.dev.healthylifestyle.utility;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dev.healthylifestyle.R;

public class FragmentHelper {
    private static final FragmentHelper ourInstance = new FragmentHelper();
    private boolean fragmentPopped;

    private FragmentHelper() {
    }

    public static FragmentHelper getInstance() {
        return ourInstance;
    }

    public void changeFragment(Fragment fragment, int layout_id, FragmentManager fragmentManager, @NonNull String tag) {
        if ((tag.trim().length() > 0)) {
            fragmentManager.findFragmentByTag(tag);
            FragmentTransaction ft = fragmentManager.beginTransaction();

            try {
                fragmentPopped = fragmentManager.popBackStackImmediate(tag, 0);

                if (!fragmentPopped) {
                    ft.replace(layout_id, fragment);
                }
                ft.addToBackStack(tag);
                ft.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_left);
                ft.commit();
            } catch (IllegalStateException e) {
                Log.e(Constants.TAG, "exception occured");
            }
        } else {
            //throw new RuntimeException(fragment.getContext().toString()
            //        + " must pass non null string for tag");
        }
    }

    public void showRoleSelectionDialogFragment(DialogFragment fragment, FragmentManager fragmentManager, @NonNull String tag) {
        if (fragment != null) {
            Fragment prev = fragmentManager.findFragmentByTag(tag);
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(tag);
            ft.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_left);

            fragment.show(ft, "dialog");

        }

    }
}
