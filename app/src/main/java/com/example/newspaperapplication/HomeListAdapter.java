package com.example.newspaperapplication;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{
    Context mContext;
    ArrayList<HashMap<String, String>> mArray;

    public HomeListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray){
        this.mContext = cxt;
        this.mArray = mArray;
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBanner;
        TextView txtTitle, txtDescription;
        public ViewHolder(View v){
            super(v);
            imgBanner = (ImageView) v.findViewById(R.id.imgbanner);
            txtTitle = (TextView) v.findViewById(R.id.txttitle);
            txtDescription = (TextView) v.findViewById(R.id.txtdescription);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        HashMap<String,String> map = mArray.get(position);
        Glide.with(mContext).load(map.get("url")).into(holder.imgBanner);
        holder.txtTitle.setText(map.get("title"));
        holder.txtDescription.setText(map.get("detail"));
        MainActivity.description=map.get("detail");
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_row, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }
}