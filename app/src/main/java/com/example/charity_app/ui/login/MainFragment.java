package com.example.charity_app.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.charity_app.R;
import com.example.charity_app.databinding.FragmentMainBinding;
import com.example.charity_app.ui.forgetpassword.ForgetPassword;
import com.example.charity_app.ui.register.ChooseRegisterType;

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
        final TextView tvForgetPassword = binding.tvForgotPassword;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goChooseFragment();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goRegisterChooseFragment(); }
        });

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goForgetPasswordFragment(); }
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

    private void goRegisterChooseFragment() {
        ChooseRegisterType chooseRegisterTypeFragment = new ChooseRegisterType();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, chooseRegisterTypeFragment, "RegisterChooseFragment")
                .addToBackStack("RegisterChoose");
        transaction.commit();
    }

    private void goForgetPasswordFragment() {
        ForgetPassword forgetPasswordFragment = new ForgetPassword();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, forgetPasswordFragment, "ForgetPassword")
                .addToBackStack("ForgetPassword");
        transaction.commit();
    }
}
