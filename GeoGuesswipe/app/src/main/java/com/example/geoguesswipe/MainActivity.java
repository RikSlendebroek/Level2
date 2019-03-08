package com.example.geoguesswipe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    private List<StreetImage> mStreetImages;
    private StreetImageAdapter mStreetAdapter;
    private RecyclerView mRecyclerView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StreetImage streetImage1 = new StreetImage("Denmark", R.drawable.img1_yes_denmark, true);
        StreetImage streetImage2 = new StreetImage("Canada", R.drawable.img2_no_canada, false);
        StreetImage streetImage3 = new StreetImage("Bangladesh", R.drawable.img3_no_bangladesh, false);
        StreetImage streetImage4 = new StreetImage("Kazachstan", R.drawable.img4_yes_kazachstan, true);
        StreetImage streetImage5 = new StreetImage("Columbia", R.drawable.img5_no_colombia, false);
        StreetImage streetImage6 = new StreetImage("Poland", R.drawable.img6_yes_poland, true);
        StreetImage streetImage7 = new StreetImage("Malta", R.drawable.img7_yes_malta, true);
        StreetImage streetImage8 = new StreetImage("Thailand", R.drawable.img8_no_thailand, false);

        mRecyclerView = findViewById(R.id.recyclerView);
        mStreetImages = new ArrayList<>();
        mStreetImages.add(streetImage1);
        mStreetImages.add(streetImage2);
        mStreetImages.add(streetImage3);
        mStreetImages.add(streetImage4);
        mStreetImages.add(streetImage5);
        mStreetImages.add(streetImage6);
        mStreetImages.add(streetImage7);
        mStreetImages.add(streetImage8);

        mRecyclerView.addOnItemTouchListener(this);

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        /*
        Add a touch helper to the RecyclerView to recognize when a user swipes to delete a list entry.
        An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
        and uses callbacks to signal when a user is performing these actions.

*/
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
               new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    // The first integer parameter refers to the dragging directions. We ignore these here.
                   // The second integer parameter refers to the swiping directions.
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }
                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        StreetImage current = mStreetImages.get(position);

                        if(swipeDir == ItemTouchHelper.LEFT && !current.isInEurope() || swipeDir == ItemTouchHelper.RIGHT && current.isInEurope()) {
                            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Whoops, that seems to be wrong!!", Toast.LENGTH_SHORT).show();
                        }

                        mStreetImages.remove(position);
                        mStreetAdapter.notifyItemRemoved(position);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mStreetAdapter = new StreetImageAdapter(this, mStreetImages);
        mRecyclerView.setAdapter(mStreetAdapter);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        int mAdapterPosition = recyclerView.getChildAdapterPosition(child);

        if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {

            Toast.makeText(this, mStreetImages.get(mAdapterPosition).getCountry(), Toast.LENGTH_SHORT).show();

        }

        return false;
    }


    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
