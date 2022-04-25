package com.example.charity_app.ui.login;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.charity_app.databinding.FragmentChooseLoginTypeBinding;

import com.example.charity_app.R;

public class ChooseLoginType extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentChooseLoginTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentChooseLoginTypeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final Button btnUser = binding.btnUser;
        final Button btnCarrier = binding.btnCarrier;
        final Button btnBenefactor = binding.btnBenefactor;
        final Button btnAdmin = binding.btnAdmin;

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

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdminFragment();
            }
        });
    }

    private void goUserFragment() {
        LoginFragment fragment = new LoginFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "LoginFragment")
                .addToBackStack("Login");
        transaction.commit();
    }

    private void goCarrierFragment() {
        CarrierLogin fragment = new CarrierLogin();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "CarrierFragment")
                .addToBackStack("Carrier");
        transaction.commit();
    }

    private void goBenefactorFragment() {
        BenefactorLogin fragment = new BenefactorLogin();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "BenefactorFragment")
                .addToBackStack("Benefactor");
        transaction.commit();
    }

    private void goAdminFragment() {
        AdminLogin fragment = new AdminLogin();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.fragment_container, fragment, "AdminFragment")
                .addToBackStack("Admin");
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}