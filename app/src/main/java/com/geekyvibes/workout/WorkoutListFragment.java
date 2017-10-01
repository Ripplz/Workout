package com.geekyvibes.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener {
        void itemClicked(int id);
    }

    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new String array with the same length as the @workouts array
        // in the Workout class
        String[] names = new String[Workout.workouts.length];

        // Populate @names with the entry in the corresponding position
        // in the @Workout.workouts array
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }

        // Create a String array adapter with the context of the inflater and
        // @names as the array source
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        // Set the adapter of the default ListView to the @adapter ArrayAdapter
        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) return;
        if (activity instanceof WorkoutListListener) {
            this.listener = (WorkoutListListener)activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement WorkoutListListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WorkoutListListener) {
            this.listener = (WorkoutListListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement WorkoutListListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(position);
        }

    }
}
