package com.example.daobunso;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class signinFragment extends Fragment {

    private Activity activity; //　取得本Fragment所依從的Activity(不是繼承關係!)


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity(); //取得本Fragment所依從的Activity(不是繼承關係!)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去


        //findViewById (帳號/密碼)
        EditText etAccount = view.findViewById(R.id.etAccount);
        EditText etPassword = view.findViewById(R.id.etPassword);


        // 點選 login 按鈕
        // 撈出使用者輸入的帳密
        view.findViewById(R.id.tvLogin).setOnClickListener(v -> {

            String account = etAccount.getText().toString().trim();
            String password = etPassword.getText().toString().trim();


            //判斷使用者是否有輸入值
            if (account.isEmpty()) {
                etAccount.setError("ACCOUNT is empty");


            }
            if (password.isEmpty()) {
                etPassword.setError("PASSWORD is empty ");

            }

            if (account.isEmpty()||password.isEmpty()) {
                etAccount.setError("ACCOUNT or PASSWORD is empty ");
                etPassword.setError("ACCOUNT or PASSWORD is empty ");

                return;

            }

            // 確認登入帳密正確，正確的話把帳密加入bundle

            bundle.putString("account", account);
            bundle.putString("password", password);


            Navigation.findNavController(v).navigate(R.id.action_signinFragment_to_indexFragment, bundle);
        });


        // 點選 建立帳號 連結
        view.findViewById(R.id.tvCreateAccount).setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_signinFragment_to_createAccountFragment, bundle);
        });
    }
}