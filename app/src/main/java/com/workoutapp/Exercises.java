package com.workoutapp;

import java.util.List;
import java.util.ArrayList;

public class Exercises {
  private String name;
  private MuscleType muscleFocused;
  List<Set> sets;

  public Exercises(String name, MuscleType muscleFocused){ //Constructor
    this.name = name;
    this.muscleFocused = muscleFocused;
    this.sets = new ArrayList<>();
  }

  public void addSet(double weight, int reps){//add set for exercises object
    sets.add(new Set(weight, reps));
  }

  public String getName(){ //return exercises name
    return name;
  }

  public MuscleType getMuscleFocused(){//return muscle focused
    return muscleFocused;
  }

  public double getTotalVolumeEx(){ //return total volume of exercises object
    double totalVolume=0;
    for(Set set: sets){
      totalVolume+=set.getReps()*set.getWeight();
    }
    return totalVolume;
  }

  public void displayExercises(){ //display exercises for log
    System.out.println(name+": " + "focus " + muscleFocused);
    for(int i=0; i < sets.size(); i++){
      System.out.println("Set " + (i+1) + ": "+ sets.get(i));
    }
  } 

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Exercise: ").append(name).append(" (Focus: ").append(muscleFocused).append(")\n");
    for(int i = 0; i<sets.size();i++){
      sb.append("Set").append(i+1).append(": ").append(sets.get(i)).append("\n"); 
    }
    return sb.toString();
  }
}
