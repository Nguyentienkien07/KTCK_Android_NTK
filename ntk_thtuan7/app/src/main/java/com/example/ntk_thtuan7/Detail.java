package com.example.ntk_thtuan7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Detail extends Fragment {

    String name,age,image;

    public Detail(String name, String age, String image) {
        this.name = name;
        this.age = age;
        this.image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.activity_detail, container, false);
        ImageView imageDetail = view.findViewById(R.id.imageviewHinh);
        TextView textName = view.findViewById(R.id.textViewFriend);
        TextView txtmota = view.findViewById(R.id.textviewMoTa);


        textName.setText(name);
        txtmota.setText(age);
        Glide.with(getContext()).load(image).into(imageDetail);

        return view;
    }


}