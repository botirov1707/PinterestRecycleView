package com.example.pinterestrecycleview.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pinterestrecycleview.R;
import com.example.pinterestrecycleview.helper.SpacesItemDecoration;
import com.example.pinterestrecycleview.model.ImageItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<ImageItem> imageItems = prepareImageList();
        refreshAdapter(imageItems);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);  // This class create Pinterest Images
        recyclerView.addItemDecoration(decoration);
    }


    private void refreshAdapter(ArrayList<ImageItem> imageItems) {
        com.example.pinterestinrv.adapter.CustomAdapter adapter = new com.example.pinterestinrv.adapter.CustomAdapter(context, imageItems);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<ImageItem> prepareImageList() {
        ArrayList<ImageItem> imageItems = new ArrayList<>();
        for (int i = 1; i < 41; i++) {
            if (i % 5 == 1) {
                imageItems.add(new ImageItem(i + "image", R.drawable.big));
            } else if (i % 5 == 3) {
                imageItems.add(new ImageItem(i + "image", R.drawable.img2));
            } else if (i % 5 == 2) {
                imageItems.add(new ImageItem(i + "image", R.drawable.img3));
            } else if(i%5 ==4) {
                imageItems.add(new ImageItem(i + "image", R.drawable.big2));
            }else{
                imageItems.add(new ImageItem(i+ "image" ,R.drawable.img));
            }
        }
        return imageItems;
    }


}