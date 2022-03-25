package com.example.drnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drnews.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustonViewHolder> {

    private final Context context;
    private final List<NewsHeadlines> headlines;
    private final SelectListener listener;


    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustonViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustonViewHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage() != null) {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}

/*
*
*
*  */
