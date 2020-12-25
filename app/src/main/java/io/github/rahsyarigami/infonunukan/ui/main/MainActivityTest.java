package io.github.rahsyarigami.infonunukan.ui.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.databinding.ActivityMainTestBinding;
import io.github.rahsyarigami.infonunukan.ui.base.BaseActivity;
import io.github.rahsyarigami.infonunukan.ui.detail.contact.ImportantContactFragment;
import io.github.rahsyarigami.infonunukan.ui.detail.deliverfood.FoodDeliverFragment;
import io.github.rahsyarigami.infonunukan.ui.detail.tour.TourFragment;
import io.github.rahsyarigami.infonunukan.ui.main.home.HomeFragment;
import io.github.rahsyarigami.infonunukan.util.ViewUtils;


public class MainActivityTest extends BaseActivity {


    LayoutInflater inflater;
    AlertDialog.Builder builder;
    View dialogView;

    private int closeApp = 2;

    private ActivityMainTestBinding mainBinding;


    private FragmentManager fragmentManager;

    private Fragment currentFragment, fragmentPage1, fragmentPage2, fragmentPage3, fragmentPage4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainTestBinding.inflate(getLayoutInflater());


        View view = mainBinding.getRoot();

        setContentView(view);

        orientationPotrait();

        setToolbar();

        fragmentPage1 = new HomeFragment();
        fragmentPage2 = new TourFragment();
        fragmentPage3 = new ImportantContactFragment();
        fragmentPage4 = new FoodDeliverFragment();

        fragmentManager = getSupportFragmentManager();

        firstFragment();

        mainBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.page_1:
                        setCurrentFragment(HomeFragment.FIRST_FRAGMENT);
                        break;
                    case R.id.page_2:
                        setCurrentFragment(TourFragment.SECOND_FRAGMENT);
                        break;
                    case R.id.page_3:
                        setCurrentFragment(ImportantContactFragment.THIRD_FRAGMENT);
                        break;
                    case R.id.page_4:
                        setCurrentFragment(FoodDeliverFragment.FOURTH_FRAGMENT);
                        break;
                }

                return true;
            }
        });


    }


    private void setToolbar() {
        setSupportActionBar(mainBinding.toolbar);
    }

    private void firstFragment() {

        if (fragmentManager.findFragmentByTag(HomeFragment.FIRST_FRAGMENT) == null) {
            fragmentManager.beginTransaction().add(R.id.frame_container, fragmentPage1, HomeFragment.FIRST_FRAGMENT).commit();
            currentFragment = fragmentPage1;
        } else {
            currentFragment = getFragmentVisible();
        }
    }

    private Fragment getFragmentVisible() {
        List<Fragment> fragmentList = fragmentManager.getFragments();
        if (fragmentList != null) {
            for (Fragment fragment : fragmentList) {
                if (fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void setCurrentFragment(String tagFragment) {

        switch (tagFragment) {
            case HomeFragment.FIRST_FRAGMENT:
                ViewUtils.fragmentTransition(fragmentManager, fragmentPage1, currentFragment, HomeFragment.FIRST_FRAGMENT);
                currentFragment = fragmentPage1;
                break;
            case TourFragment.SECOND_FRAGMENT:
                ViewUtils.fragmentTransition(fragmentManager, fragmentPage2, currentFragment, TourFragment.SECOND_FRAGMENT);
                currentFragment = fragmentPage2;
                break;
            case ImportantContactFragment.THIRD_FRAGMENT:
                ViewUtils.fragmentTransition(fragmentManager, fragmentPage3, currentFragment, ImportantContactFragment.THIRD_FRAGMENT);
                currentFragment = fragmentPage3;
                break;
            case FoodDeliverFragment.FOURTH_FRAGMENT:
                ViewUtils.fragmentTransition(fragmentManager, fragmentPage4, currentFragment, FoodDeliverFragment.FOURTH_FRAGMENT);
                currentFragment = fragmentPage4;
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                intentShare();
                break;
            case R.id.action_about:
                dialogAbout();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void intentShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=io.github.rahsyarigami.infonunukan");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.txt_send_to)));
    }

    @SuppressLint("InflateParams")
    private void dialogAbout() {
        builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_app_about, null);
        builder.setView(dialogView);
        builder.setCancelable(true);
        builder.show();
    }

    @Override
    public void onBackPressed() {

        closeApp -= 1;
        switch (closeApp) {
            case 1:
                Toast.makeText(getApplicationContext(), "Tekan kembali lagi untuk keluar", Toast.LENGTH_LONG).show();
                break;
            case 0:
                moveTaskToBack(true);
                finish();
                break;
        }

    }


}
