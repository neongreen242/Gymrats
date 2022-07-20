package com.example.gymrats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymrats.fragments.ComposeFragment;
import com.example.gymrats.fragments.CategoryFragment;
import com.example.gymrats.fragments.HomeFragment;
import com.example.gymrats.fragments.MapFragment;
import com.example.gymrats.fragments.ProfileFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    protected ImageButton btnLogout;
    public static final String TAG = "TAG";
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogout = findViewById(R.id.logout);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        //Logouts user from the main platform
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOutInBackground();
                Intent i = new Intent(MainActivity.this,StartingActivity.class);
                startActivity(i);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home!!", Toast.LENGTH_SHORT).show();
                        fragment = new HomeFragment();

                        break;
                    case R.id.action_compose:
                        Toast.makeText(MainActivity.this, "Compose!!", Toast.LENGTH_SHORT).show();

                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_gyms:
                        Toast.makeText(MainActivity.this, "Gyms!!", Toast.LENGTH_SHORT).show();
                        fragment = new MapFragment();

                        break;
                    case R.id.action_exercise:
                        Toast.makeText(MainActivity.this, "Exercise!!", Toast.LENGTH_SHORT).show();
                        fragment = new CategoryFragment();

                        break;
                    case R.id.action_profile:
                        Toast.makeText(MainActivity.this, "Profile!!", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();

                        break;

                    default:
                        fragment = new HomeFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;

            }
        });
        //Set default to home
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }



}