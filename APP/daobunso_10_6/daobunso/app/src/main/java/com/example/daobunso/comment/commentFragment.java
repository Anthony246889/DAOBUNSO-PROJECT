package com.example.daobunso.comment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.daobunso.R;

public class commentFragment extends Fragment {
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle((R.string.comment));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        RatingBar ratingBar = view.findViewById(R.id.rbStars);
//        ratingBar.setOnRatingBarChangeListener((ratBar, rating, fromUser) -> {
//            String text = rating + " star(s)";
//            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//        });   待資料庫連線修改


        view.findViewById(R.id.btnCommentsubmit).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_thanksFragment);
        });


        // 右上角回首頁、shoppingCart
        view.findViewById(R.id.ivHome).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_indexFragment));

        view.findViewById(R.id.ivShippingcart).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_serviceFragment));

    }



}