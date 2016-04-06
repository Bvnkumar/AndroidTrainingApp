package com.bvnkumar.androidtrainingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by bvnkumar on 6/4/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecylerViewHolder> {
    String[] mobile_brand;
    String[] mobile_name;
    int android_image_urls[];
    public RecyclerAdapter(String[] mobile_brand,String[] mobile_name,int android_image_urls[])

    {
        this.mobile_brand=mobile_brand;
        this.mobile_name=mobile_name;
        this.android_image_urls=android_image_urls;
    }
    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycleview,parent,false);
        RecylerViewHolder recyclerViewHolder=new RecylerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {
holder.tx_mobilebrand.setText(mobile_brand[position]);
        holder.tx_mobilename.setText(mobile_name[position]);
        holder.imageView.setImageResource((android_image_urls[position]));

    }

    @Override
    public int getItemCount() {
        return mobile_brand.length;
    }

    public class RecylerViewHolder extends RecyclerView.ViewHolder {
        TextView tx_mobilename,tx_mobilebrand;
        ImageView imageView;
        public RecylerViewHolder(View itemView) {
            super(itemView);
            tx_mobilename=(TextView)itemView.findViewById(R.id.list_title);
            tx_mobilebrand=(TextView)itemView.findViewById(R.id.list_desc);
            imageView=(ImageView)itemView.findViewById(R.id.list_avatar);

        }
    }
}
