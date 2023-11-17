package com.example.qrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.qrapp.databinding.ActivityMainBinding;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replaceFragment(new Locations());
        binding.bottomNavView.setBackground(null);
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.locations:
                    replaceFragment(new Locations());
                    break;
                case R.id.qr:
                    startActivity(
                            FlutterActivity
                                    .withNewEngine()
                                    .initialRoute("/") // replace with your desired route
                                    .build(this)
                    );
                    break;
                case R.id.networks:
                    replaceFragment(new Networks());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}