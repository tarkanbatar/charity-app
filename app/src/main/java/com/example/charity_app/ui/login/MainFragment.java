package com.example.charity_app.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.charity_app.R;
import com.example.charity_app.databinding.FragmentMainBinding;

/**
 * Created by Tarkan BATAR on 25.04.2022
 * Copyright (c) 2022 ProcedureSoft All rights reserved.
 */
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button btnLogin = binding.btnLogin;
        final Button btnRegister = binding.btnRegister;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goChooseFragment();
            }
        });
    }

    private void goChooseFragment() {
        ChooseLoginType chooseLoginTypeFragment = new ChooseLoginType();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
            .replace(R.id.fragment_container, chooseLoginTypeFragment, "ChooseFragment")
            .addToBackStack("Choose");
        transaction.commit();
    }
}
