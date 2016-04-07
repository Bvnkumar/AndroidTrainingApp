package com.bvnkumar.androidtrainingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


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
    public void onBindViewHolder(RecylerViewHolder holder, final int position) {
holder.tx_mobilebrand.setText(mobile_brand[position]);
        holder.tx_mobilename.setText(mobile_name[position]);
        holder.imageView.setImageResource((android_image_urls[position]));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;

//                if (((CheckBox)v).isChecked())
//                    Toast.makeText(v.getContext(),"hello",Toast.LENGTH_SHORT).show();
                StringBuffer str=new StringBuffer();
               // str.append(cb.isChecked());

                if (cb.isChecked()==true)
               {
                   str.append(mobile_brand[position]);
             }
              Toast.makeText(v.getContext(),"Brand: "+mobile_brand[position]+" Model: "+mobile_name[position],Toast.LENGTH_SHORT).show();
              // Toast.makeText(v.getContext(),str.toString(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder a_alert=new AlertDialog.Builder(v.getContext());
                a_alert.setMessage("Brand: "+mobile_brand[position]+" Name: "+mobile_name[position]).setCancelable(true)


                        .setNegativeButton("Close Alert", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });
                AlertDialog alert=a_alert.create();
                alert.setTitle("Alert");
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mobile_brand.length;
    }

    public class RecylerViewHolder extends RecyclerView.ViewHolder {
        TextView tx_mobilename,tx_mobilebrand;
        ImageView imageView;
        CheckBox checkBox;
        public RecylerViewHolder(View itemView) {
            super(itemView);
            tx_mobilename=(TextView)itemView.findViewById(R.id.list_title);
            tx_mobilebrand=(TextView)itemView.findViewById(R.id.list_desc);
            imageView=(ImageView)itemView.findViewById(R.id.list_avatar);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkBox1);

        }
    }
}
