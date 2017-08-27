package com.iak.finalproject.listiani.popularmovielisti.ui;

import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.iak.finalproject.listiani.popularmovielisti.R;
import com.iak.finalproject.listiani.popularmovielisti.model.MovieEntity;
import com.iak.finalproject.listiani.popularmovielisti.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ACER on 26/08/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter {
    private List<MovieEntity> items = new ArrayList<>();
//    public interface MovieAdapterOnClickHandler{
//
//    }
    //    Memasukkan data yang sudah ada
    public void setItems(List<MovieEntity> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MovieHolder movieHolder = (MovieHolder) holder;
        movieHolder.bind(ImageUtils.generateImageUrl(
                items.get(position).getPosterPath()));
        movieHolder.moviePosterView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = String.valueOf(position);
                String title = items.get(position).getTitle();
//                Snackbar.make(v, "Title "+title, Snackbar.LENGTH_LONG).show();
//                Log.d("Keklik","Yes berhasil keklik");
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(@LayoutRes int resId, ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        }
    }

    public static class MovieHolder extends BaseHolder {
        private ImageView moviePosterView;

        public MovieHolder(ViewGroup parent) {
            super(R.layout.item_movie, parent);
            moviePosterView = (ImageView) itemView.findViewById(R.id.movie_poster);
        }

        public void bind(String imageUrl) {
            Picasso.with(itemView.getContext())
                    .load(imageUrl)
                    .into(moviePosterView);
//            kalo mau pake fit dan centercrop, jangan lupa set placeholder di itemnya
        }
    }
}
