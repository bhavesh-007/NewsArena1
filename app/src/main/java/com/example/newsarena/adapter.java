package com.example.newsarena;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    ArrayList<modalclass> modalclassArrayList;

    public adapter(Context context, ArrayList<modalclass> modalclassArrayList) {
        this.context = context;
        this.modalclassArrayList = modalclassArrayList;
    }

    @NonNull
    
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.activity_item,null,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webview.class);
                intent.putExtra("url",modalclassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At - "+modalclassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText("Article By - "+modalclassArrayList.get(position).getAuthor());
        holder.mhead.setText(modalclassArrayList.get(position).getTitle());
        holder.mcontent.setText(modalclassArrayList.get(position).getDescription());
        Glide.with(context).load(modalclassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modalclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView mhead,mcontent,mauthor,mtime;
       CardView cardView;
       ImageView imageView;

       public ViewHolder(View itemview)
       {
           super(itemview);
           mhead=itemview.findViewById(R.id.mainhead);
           mcontent=itemview.findViewById(R.id.contents);
           mauthor=itemview.findViewById(R.id.author);
           mtime=itemview.findViewById(R.id.timeee);
           imageView=itemview.findViewById(R.id.imagee);
           cardView=itemview.findViewById(R.id.cardview);

        }
    }
}
