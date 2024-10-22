package com.workoutapp;

public class Set {
  private int reps;
  private double weight;

  public Set(double weight, int reps){
    this.reps=reps;
    this.weight=weight;
  }

  public int getReps(){
    return reps;
  }

  public double getWeight(){
    return weight;
  }

  @Override
  public String toString() {
    return reps + "reps at " + weight + "kg";
  }
  
}
