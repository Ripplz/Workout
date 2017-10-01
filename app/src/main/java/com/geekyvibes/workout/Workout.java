package com.geekyvibes.workout;

/**
 * Created by DELL on 9/27/2017.
 */

public class Workout {

    // The name of the current Workout
    private String name;

    // The description of the current Workout
    private String description;

    // An array of Workout(s) that are in turn holders of their respective names and descriptions
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony", "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length", "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    // Each Workout object should have a @name and a @description
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Get the name of the current Workout
    public String getName() {
        return this.name;
    }

    // Get the description of the current Workout
    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.name;
    }
}
;