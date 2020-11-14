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

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    List<SingleNews> newsList;
    Context context;

    public NewsAdapter(List<SingleNews> newsList, Context context ){
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_row, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        SingleNews singleNews = newsList.get(i);
        newsHolder.title.setText(singleNews.getTittleOfNews());
        newsHolder.description.setText(singleNews.getDescriptionOfNews());
        newsHolder.avatar.setImageResource(singleNews.getAvatar());
        final String titleOfNews = singleNews.getTittleOfNews();
        final String descriptionOfNews = singleNews.getDescriptionOfNews();
        newsHolder.mainNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchNewIntent = new Intent(context, DetailNews.class);
                launchNewIntent.putExtra("title_of_news", titleOfNews);
                launchNewIntent.putExtra("description_of_news", descriptionOfNews);
                context.startActivity(launchNewIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
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
