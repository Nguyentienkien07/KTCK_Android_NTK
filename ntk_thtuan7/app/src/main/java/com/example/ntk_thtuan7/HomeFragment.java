package com.example.ntk_thtuan7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rcvNews;
    private NewsAdapter newsAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);
       rcvNews = view.findViewById(R.id.rcv_news);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvNews.setLayoutManager(linearLayoutManager);

        newsAdapter = new NewsAdapter(getListNews());
        rcvNews.setAdapter(newsAdapter);
            return view;
        }
        private List<News> getListNews(){
            List<News> list = new ArrayList<>();
            list.add(new News(R.drawable.hinh2, R.drawable.hinh2, "Duy Hoàng"));
            list.add(new News(R.drawable.hinh3, R.drawable.hinh3, "Phước Lục"));
            list.add(new News(R.drawable.hinh4, R.drawable.hinh4, "Viết Thịnh"));
            list.add(new News(R.drawable.hinh5, R.drawable.hinh5, "Viết Ý"));

            list.add(new News(R.drawable.h6, R.drawable.h6, "Văn Thành"));
            list.add(new News(R.drawable.hinh7, R.drawable.hinh7, "Hữu Tam"));
            list.add(new News(R.drawable.hinh8, R.drawable.hinh8, "Văn Khánh"));
            list.add(new News(R.drawable.hinh2, R.drawable.hinh2, "duy hoang"));

            list.add(new News(R.drawable.hinh3, R.drawable.hinh3, "Phước Lục"));
            list.add(new News(R.drawable.hinh4, R.drawable.hinh4, "Viết Thịnh"));
            list.add(new News(R.drawable.hinh5, R.drawable.hinh5, "Viết Ý"));
            list.add(new News(R.drawable.h6, R.drawable.h6, "Văn Thành"));

            return list;
        }

}




