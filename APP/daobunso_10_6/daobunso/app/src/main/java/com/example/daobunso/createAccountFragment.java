package com.example.daobunso;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class createAccountFragment extends Fragment {

    private Activity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去

        //findViewById
        EditText etInsertAccount = view.findViewById(R.id.etInsertAccount);
        EditText etEmail = view.findViewById(R.id.etEmail);
        EditText etInsertPassword = view.findViewById(R.id.etInsertPassword);
        EditText etPasswordAgain = view.findViewById(R.id.etPasswordAgain);



        // 點選 create 按鈕
        view.findViewById(R.id.createAccountBtn).setOnClickListener(v -> {

            String newAccount = etInsertAccount.getText().toString().trim();
            String newEmail = etEmail.getText().toString().trim();
            String newPassword = etInsertPassword.getText().toString().trim();
            String passwordAgain = etPasswordAgain.getText().toString().trim();


            //判斷使用者是否有輸入值
            if (newAccount.isEmpty()) {
                etInsertAccount.setError("ACCOUNT is empty");


            }
            if (newEmail.isEmpty()) {
                etEmail.setError("EMAIL is empty ");

            }

            if (newPassword.isEmpty()) {
                etInsertPassword.setError("PASSWORD is empty ");

            }


            if (passwordAgain.isEmpty()) {
                etPasswordAgain.setError("PASSWORD AGAIN is empty ");

            }

            if (newAccount.isEmpty()||newEmail.isEmpty() || newPassword.isEmpty() || passwordAgain.isEmpty()) {
                etInsertAccount.setError("仍有未填寫資料");


                return;

            }

            bundle.putString("newAccount", newAccount);
            bundle.putString("newEmail", newEmail);
            bundle.putString("newPassword", newPassword);

            new AlertDialog.Builder(activity) //內部類別，new後得到Builder物件
                    // 設定標題
                    .setTitle(R.string.textTitle)
                    // 設定圖示
                    .setIcon(R.drawable.logo)
                    // 設定訊息文字
                    .setMessage(R.string.textMessage)
                    // 設定positive與negative按鈕上面的文字與點擊事件監聽器
                    .setPositiveButton(R.string.textYes, (dialog, which) -> Navigation.findNavController(v).navigate(R.id.action_createAccountFragment_to_indexFragment, bundle)) // 結束此Activity頁面
                    .setCancelable(false) // 必須點擊按鈕方能關閉，預設為true
                    .show();


        });

    }

}