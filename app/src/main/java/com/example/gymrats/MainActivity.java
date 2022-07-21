package com.example.gymrats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    protected Button btnFilter;
    protected ImageButton btnLogout;
    public static final String TAG = "TAG";
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.logout);
        btnFilter = findViewById(R.id.btnFilter);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
                builderSingle.setIcon(R.drawable.gymrats_logo);
                builderSingle.setTitle("Filter");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("ARMS");
                arrayAdapter.add("LEGS");
                arrayAdapter.add("CHEST");
                arrayAdapter.add("LEGS");
                arrayAdapter.add("ABS");

                builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                dialog.dismiss();
                            }
                        });
                        builderInner.show();
                    }
                });
                builderSingle.show();
            }
        });

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