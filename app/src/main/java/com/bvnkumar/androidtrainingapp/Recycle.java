package com.bvnkumar.androidtrainingapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Recycle extends AppCompatActivity {
RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public String[] mobile_brand={"samsung","Apple","Lenovo","Nokia","samsung","Apple","Lenovo","Nokia"};
    public String[] mobile_name={"hero","i6","A7000","200","hero","i6","A7000","200"};
    public final int[] android_image_urls = {R.mipmap.mob1,R.mipmap.mob2,R.mipmap.mob1,R.mipmap.mob2,R.mipmap.mob1,R.mipmap.mob1,R.mipmap.mob2,R.mipmap.mob1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        adapter=new RecyclerAdapter(mobile_brand,mobile_name,android_image_urls);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
