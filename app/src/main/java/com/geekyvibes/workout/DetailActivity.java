package com.geekyvibes.workout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by DELL on 9/30/2017.
 * For normal smartphones
 */

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        WorkoutDetailFragment df = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutID = (int) getIntent().getExtras().get(EXTRA_ID);
        df.setWorkout(workoutID);
    }

}
