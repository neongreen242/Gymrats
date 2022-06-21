package com.example.gymrats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_compose:
                        Toast.makeText(MainActivity.this, "Compose!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_gyms:
                        Toast.makeText(MainActivity.this, "Gyms!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_exercise:
                        Toast.makeText(MainActivity.this, "Exercise!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        Toast.makeText(MainActivity.this, "Profile!!", Toast.LENGTH_SHORT).show();
                        break;

                    default: break;
                }
                return true;

            }
        });


    }

}