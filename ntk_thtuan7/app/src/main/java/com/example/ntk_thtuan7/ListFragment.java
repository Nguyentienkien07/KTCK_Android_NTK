package com.example.ntk_thtuan7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    FriendsAdapter friendsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        FirebaseRecyclerOptions<FriendsModel> options =
                new FirebaseRecyclerOptions.Builder<FriendsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("friend"),FriendsModel.class)
                        .build();

        friendsAdapter = new FriendsAdapter(options);
        recyclerView.setAdapter(friendsAdapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        friendsAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        friendsAdapter.startListening();
    }
}
