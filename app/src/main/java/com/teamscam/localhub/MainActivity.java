package com.teamscam.localhub;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.teamscam.localhub.ui.dashboard.DashboardFragment;
import com.teamscam.localhub.ui.home.HomeFragment;
import com.teamscam.localhub.ui.notifications.NotificationsFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    public static TextView fragmentTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        Window window = getWindow();
        Drawable bg = getDrawable(R.drawable.bg_bar);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(bg);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

//        BottomNavigationView navigationView = findViewById(R.id.nav_view);
//        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                Fragment selectedFragment=null;
//                switch(menuItem.getItemId()){
//                    case R.id.navigation_home:
//                        selectedFragment = new HomeFragment();
//                        break;
//                    case R.id.navigation_dashboard:
//                        selectedFragment = new DashboardFragment();
//                        break;
//                    case R.id.navigation_notifications:
//                        selectedFragment = new NotificationsFragment();
//                        break;
//
//                }
//                assert selectedFragment != null;
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.nav_host_fragment, selectedFragment)
//                        .addToBackStack(null)
//                        .commit();
//                return true;
//            }
//        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        startActivity(intent);
    }
}
