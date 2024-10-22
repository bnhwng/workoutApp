package com.workoutapp;
import javax.tools.DiagnosticListener;

import com.workoutapp.MuscleType;

public final class Workout {
    private Workout() {
    }

    public static void main(String[] args) {
        DailyWorkoutLog log = new DailyWorkoutLog(BasedMovement.PUSH);
        Exercises dumbbellPress = new Exercises("Dumbbell Incline Press", MuscleType.CHEST);    
        dumbbellPress.addSet(37.5, 10);
        dumbbellPress.addSet(37.5, 9);
        dumbbellPress.addSet(37.5, 8);
        
        Exercises benchPress = new Exercises("Bench Press", MuscleType.CHEST);
        benchPress.addSet(115, 5);
        benchPress.addSet(115, 4);
        benchPress.addSet(115, 4);

        Exercises lateralRaises = new Exercises("Lateral Raises", MuscleType.SHOULDERS);
        lateralRaises.addSet(12.5, 12);
        lateralRaises.addSet(12.5, 10);
        lateralRaises.addSet(12.5, 10);
        

        log.addExercises(dumbbellPress);
        log.addExercises(benchPress);
        log.addExercises(lateralRaises);
        System.out.println(log.toString());
        }
}
