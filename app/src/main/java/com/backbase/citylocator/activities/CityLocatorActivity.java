package com.backbase.citylocator.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.ActionBar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.backbase.citylocator.R;
import com.backbase.citylocator.fragments.CitiesFragment;
import com.backbase.citylocator.fragments.HelperFragment;

public class CityLocatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_locator);

        addCityFragment(savedInstanceState);
    }

    public void addCityFragment(Bundle savedInstanceState) {
        Fragment cityLocatorContainerFragment = getSupportFragmentManager().
                findFragmentById(R.id.framelayout_city_locator_container);

        if (savedInstanceState != null && cityLocatorContainerFragment != null) {
            loadRespectiveActiveFragment();
        } else {
            CitiesFragment citiesFragment = new CitiesFragment();

            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,
                            R.anim.enter_from_left, R.anim.exit_to_left)
                    .replace(R.id.framelayout_city_locator_container, citiesFragment, citiesFragment.getFragmentTag())
                    .commit();
        }

    }

    private void loadRespectiveActiveFragment() {
        Fragment currentFragment = getSupportFragmentManager().
                findFragmentById(R.id.framelayout_city_locator_container);
        if (currentFragment != null && currentFragment instanceof HelperFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,
                            R.anim.enter_from_left, R.anim.exit_to_left)
                    .replace(R.id.framelayout_city_locator_container, currentFragment, ((HelperFragment) currentFragment).getFragmentTag())
                    .commit();
        } else if (currentFragment != null) {
            Log.e("loadRespectiveActiveFra", "loadRespectiveActiveFragment: Fragment  does NOT extend HelperFragment, not proceeding to next fragment");
        }
    }
}
