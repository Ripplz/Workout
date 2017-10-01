package com.geekyvibes.workout;


import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    // This is the ID of the Workout the user chooses
    private int workoutId = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // If the app is starting afresh, put a new instance of the Stopwatch fragment
        // in the corresponding FrameLayout.
        // Else, let the app continue from where it stopped.
        if (savedInstanceState != null) {
            // Set the value of @workoutId to its value before the app was paused or stopped.
            workoutId = savedInstanceState.getInt("workoutID");
        } else {
            // If the phone runs API 17 and above,
            //      begin a new Fragment transaction from the Activity's Fragment manager.
            // Else if the phone runs lower than API 17,
            //      begin a new Fragment transaction from this fragment's child fragment manager.
            FragmentTransaction ft;
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                ft = getChildFragmentManager().beginTransaction();
            } else {
                ft = getFragmentManager().beginTransaction();
            }

            // Prepare the stopwatch fragment to be added to the layout.
            StopwatchFragment stopwatchFragment = new StopwatchFragment();

            // Replace the fragment in the framelayout with the one prepared above
            ft.replace(R.id.stopwatch, stopwatchFragment);

            // If the phone runs API 17 & above, add @ft to the back stack.
            // This is to ensure that the back button doesn't create funny scenarios if the phone
            // runs on less than API 17.
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                ft.addToBackStack(null);
            }

            // Set a transition for the transaction
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            // Commit it to the activity
            ft.commit();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get the fragment's root view
        View view = getView();

        // If the view isn't null, get the Workout.workouts entry that corresponds to the
        // position ID passed by the MainActivity and set the name and description
        // TextViews to the appropriate content
        if (view != null) {
            Workout workout = Workout.workouts[workoutId];
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(workout.getName());
            TextView desc = (TextView) view.findViewById(R.id.description);
            desc.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current value of @workoutId for use when the activity is re-resumed.
        outState.putInt("workoutID", workoutId);
    }

    public void setWorkout(int id) {
        this.workoutId = id;
    }

}
