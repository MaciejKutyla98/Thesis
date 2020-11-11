package com.example.thesis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    String title_of_news[], description_of_news[];
    int avatars[];
    Context context;

    public NewsAdapter(Context ct, String title[], String description[], int img[]){
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
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, @SuppressLint("RecyclerView") final int i) {
        newsHolder.title.setText(title_of_news[i]);
        newsHolder.description.setText(description_of_news[i]);
        newsHolder.avatar.setImageResource(avatars[i]);
        newsHolder.mainNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchNewIntent = new Intent(context, DetailNews.class);
                launchNewIntent.putExtra("title_of_news", title_of_news[i]);
                launchNewIntent.putExtra("description_of_news", description_of_news[i]);
                context.startActivity(launchNewIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        ImageView avatar;

        ConstraintLayout mainNews;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_tittle_txt);
            description = itemView.findViewById(R.id.news_description_txt);
            avatar = itemView.findViewById(R.id.type_of_news_img);
            mainNews = itemView.findViewById(R.id.mainNews);
        }
    }
}
