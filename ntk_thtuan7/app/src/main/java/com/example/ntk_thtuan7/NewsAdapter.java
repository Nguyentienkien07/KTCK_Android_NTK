package com.example.ntk_thtuan7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.UserViewHolder>{

    private Context mContext;
    private List<News> mListNews;

    public NewsAdapter(List<News> mListNews) {
        this.mListNews = mListNews;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        News computer = mListNews.get(position);
        if (computer == null) {
            return;
        }

        holder.img_news.setImageResource(computer.getResourceId());
        holder.img_name.setImageResource(computer.getResourceId());
        holder.tvName.setText(computer.getName());
    }

    @Override
    public int getItemCount() {
        if (mListNews != null) {
            return mListNews.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_name, img_news;
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img_news = itemView.findViewById(R.id.img_news);
            img_name = itemView.findViewById(R.id.img_name);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}




