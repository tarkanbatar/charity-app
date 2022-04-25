package com.example.charity_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.charity_app.databinding.ActivityMainBinding;
import com.example.charity_app.ui.login.ChooseLoginType;
import com.example.charity_app.ui.login.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        MainFragment mainFragment = new MainFragment();
        manager.beginTransaction()
                .replace(R.id.fragment_container, mainFragment, "Main")
                .commit();
    }
}