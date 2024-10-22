package com.workoutapp;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExercisesTest {

    @Test
    public void testAddSetAndTotalVolume() {
        // Create a new exercise and add sets
        Exercises benchPress = new Exercises("Bench Press", MuscleType.CHEST);
        benchPress.addSet(60.0, 10); // 60 kg, 10 reps
        benchPress.addSet(70.0, 8);  // 70 kg, 8 reps
        
        // Assert the total volume is calculated correctly
        double expectedVolume = (10 * 60.0) + (8 * 70.0);
        assertEquals(expectedVolume, benchPress.getTotalVolumeEx(), 0.01);
    }

    @Test
    public void testDisplayExercises() {
        Exercises deadlift = new Exercises("Deadlift", MuscleType.UPPER_BACK);
        deadlift.addSet(100.0, 5);
        deadlift.addSet(120.0, 3);

        // Use display method (normally tested manually, but you can capture output)
        deadlift.displayExercises();
    }

    @Test
    public void testDailyWorkoutLogVolumeCalculation() {
        // Create a new DailyWorkoutLog
        DailyWorkoutLog log = new DailyWorkoutLog(BasedMovement.PUSH);

        // Create exercises
        Exercises shoulderPress = new Exercises("Shoulder Press", MuscleType.SHOULDERS);
        shoulderPress.addSet(30.0, 8);
        shoulderPress.addSet(32.5, 6);

        Exercises tricepPushdown = new Exercises("Tricep Pushdown", MuscleType.TRICEPS);
        tricepPushdown.addSet(20.0, 12);
        tricepPushdown.addSet(22.5, 10);

        // Add exercises to the workout log
        log.addExercises(shoulderPress);
        log.addExercises(tricepPushdown);

        // Calculate the expected total volume
        double expectedVolume = (8 * 30.0) + (6 * 32.5) + (12 * 20.0) + (10 * 22.5);
        assertEquals(expectedVolume, log.getTotalVolume(), 0.01);
    }

    @Test
    public void testFutureDateWorkoutLog() {
        // Create a workout log for a future date
        LocalDate futureDate = LocalDate.now().plusDays(7);
        DailyWorkoutLog futureWorkout = new DailyWorkoutLog(BasedMovement.PULL, futureDate);

        // Assert the date is correctly set
        assertEquals(futureDate, futureWorkout.getDate());
    }

    @Test
    public void testToStringMethodForDailyWorkoutLog() {
        DailyWorkoutLog workoutLog = new DailyWorkoutLog(BasedMovement.LEG_QUAD);
        Exercises squats = new Exercises("Squats", MuscleType.QUADS);
        squats.addSet(100.0, 10);
        squats.addSet(120.0, 8);

        workoutLog.addExercises(squats);

        String expectedOutput = "Workout Log - Date: LEG_QUAD" + workoutLog.getDate() + "/n"
                + "ExercisesSquats (Focus: QUADS)\n"
                + "Set1: 10 reps at 100.0kg\n"
                + "Set2: 8 reps at 120.0kg\n";

        assertTrue(workoutLog.toString().contains("Exercise: Squats (Focus: QUADS)"));
    }
}