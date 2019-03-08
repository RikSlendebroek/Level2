package com.example.geoguesswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StreetImage[] mStreetImages;
    private StreetImageAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StreetImage streetImage1 = new StreetImage( "Denmark", R.drawable.img1_yes_denmark, true );
        StreetImage streetImage2 = new StreetImage( "Canada", R.drawable.img2_no_canada, false );
        StreetImage streetImage3 = new StreetImage( "Bangladesh", R.drawable.img3_no_bangladesh, false );

        mRecyclerView = findViewById(R.id.recyclerView);
        mStreetImages = new StreetImage[3];
        mStreetImages[0] = streetImage1;
        mStreetImages[1] = streetImage2;
        mStreetImages[2] = streetImage3;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        StreetImageAdapter sa = new StreetImageAdapter( mStreetImages );
        mRecyclerView.setAdapter( new StreetImageAdapter( mStreetImages) );
    }
}
