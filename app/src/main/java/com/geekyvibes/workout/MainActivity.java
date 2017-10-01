package com.geekyvibes.workout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    private View fragmentContainer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Look for the FrameLayout with the below id in the main layout.
        // Here, this is used to confirm if the app is running on a tablet.
        // If so, the layout would surely contain the FrameLayout and return a valid view.
        // If not, the view wouldn't be found and a value of null is returned.
        // So, if the app is running on a tablet, a fragment will be added
        // to the FrameLayout as appropriate.
        fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, details);
            transaction.commit();
        }
    }

    @Override
    public void itemClicked(int id) {
        // If so, the layout would surely contain the FrameLayout and return a valid view.
        // If not, the view wouldn't be found and a value of null is returned.
        // So, if the app is running on a tablet, a fragment will be added
        // to the FrameLayout as appropriate
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            transaction.replace(R.id.fragment_container, details);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ID, id);
            startActivity(intent);
        }
    }
}
