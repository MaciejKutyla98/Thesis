package com.example.thesis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerNewsAdapter extends RecyclerView.Adapter<RecyclerNewsAdapter.NewsHolder> {

    String title_of_news[], description_of_news[];
    int avatars[];
    Context context;

    public  RecyclerNewsAdapter(Context ct, String title[], String description[], int img[]){
        this.context = ct;
        this.title_of_news = title;
        this.description_of_news = description;
        this.avatars = img;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_row, viewGroup, false);
        return new  NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        newsHolder.title.setText(title_of_news[i]);
        newsHolder.description.setText(description_of_news[i]);
        newsHolder.avatar.setImageResource(avatars[i]);
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        ImageView avatar;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_tittle_txt);
            description = itemView.findViewById(R.id.news_description_txt);
            avatar = itemView.findViewById(R.id.type_of_news_img);
        }
    }
}
