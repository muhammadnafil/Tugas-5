package com.nafil.fragmentbuttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    // Deklarasi buttom navigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memberikan action pada pada buttom navigation
        bottomNavigation = findViewById(R.id.buttom_navigation);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //Memberi action pada button
                Fragment selectedFragment = null;

                switch (item.getItemId()) {

                    //Memberi action button home
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;

                    //Memberi action button food
                    case R.id.nav_food:
                        selectedFragment = new FoodFragment();
                        break;

                    //Memberi action button drink
                    case R.id.nav_drink:
                        selectedFragment = new DrinkFragment();
                        break;

                    //Memberi action button airport
                    case R.id.nav_airport:
                        selectedFragment = new AirportFragment();
                        break;
                }

                //Membuat fungsi untuk mengubah fragment sehingga dapat berganti sesuai dengan value yang ada di dalam selectedFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }
}