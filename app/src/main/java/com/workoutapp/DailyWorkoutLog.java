package com.workoutapp;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class DailyWorkoutLog {
  private LocalDate date;
  private List<Exercises> exercises;
  private BasedMovement basedMovement;

  public DailyWorkoutLog(BasedMovement basedMovement){
    this.date = LocalDate.now(); //today set
    this.exercises= new ArrayList<>();
    this.basedMovement=basedMovement;
  }

  public DailyWorkoutLog(BasedMovement basedMovement, LocalDate date){
    this.date=date; //future 
    this.exercises=new ArrayList<>();
    this.basedMovement=basedMovement;
  }

  //add exercises
  public void addExercises(Exercises exercise){
    exercises.add(exercise);
  }

  public void removeExercises(Exercises exercise){
    exercises.remove(exercise);
  }

  //Getters
  public LocalDate getDate(){
    return date;
  }

  public List<Exercises> getExercises(){
    return exercises;
  }

  public double getTotalVolume(){
    double totalDailyVolume = 0;
    for(Exercises ex: exercises){
      totalDailyVolume+=ex.getTotalVolumeEx();
    }
    return totalDailyVolume;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Workout Log - Date: ").append(basedMovement).append(date).append("/n");
    for(Exercises ex: exercises){
      sb.append(ex).append("\n");
    }
    return sb.toString();
  }
}
