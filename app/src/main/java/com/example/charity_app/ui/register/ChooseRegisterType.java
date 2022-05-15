package com.example.charity_app.ui.register;

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
import com.example.charity_app.databinding.FragmentChooseRegisterTypeBinding;
import com.example.charity_app.ui.login.AdminLogin;
import com.example.charity_app.ui.login.BenefactorLogin;
import com.example.charity_app.ui.login.CarrierLogin;
import com.example.charity_app.ui.login.LoginFragment;

public class ChooseRegisterType extends Fragment {

    private FragmentChooseRegisterTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChooseRegisterTypeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final Button btnUser = binding.btnUser;
        final Button btnCarrier = binding.btnCarrier;
        final Button btnBenefactor = binding.btnBenefactor;

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUserFragment();
            }
        });

        btnCarrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goCarrierFragment();
            }
        });

        btnBenefactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBenefactorFragment();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    private void goUserFragment() {
        RegisterFragment fragment = new RegisterFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "RegisterFragment")
                .addToBackStack("Register");
        transaction.commit();
    }

    private void goCarrierFragment() {
        CarrierRegister fragment = new CarrierRegister();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "RegisterCarrierFragment")
                .addToBackStack("RegisterCarrier");
        transaction.commit();
    }

    private void goBenefactorFragment() {
        BenefactorRegister fragment = new BenefactorRegister();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "RegisterBenefactorFragment")
                .addToBackStack("RegisterBenefactor");
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
