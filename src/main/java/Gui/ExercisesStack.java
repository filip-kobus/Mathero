package Gui;

import java.util.ArrayList;

public class ExercisesStack {
    private final ArrayList<ArrayList<String>> allExercise;
    private ArrayList<String> exercise;
    private int currIndeks;

    public ExercisesStack() {
        this.allExercise = new ArrayList<>();
        this.exercise = new ArrayList<>();
        this.currIndeks = -1;
    }

    public ArrayList<String> getPrevious() {
        if(currIndeks <= 0) return this.allExercise.get(this.currIndeks);
        this.currIndeks--;
        exercise = this.allExercise.get(this.currIndeks);
        return exercise;
    }

    public void push(ArrayList<String> element) {
        this.exercise = element;
        this.allExercise.add(this.exercise);
        this.currIndeks++;
    }

    public ArrayList<String> getExercise() {
        return this.allExercise.get(this.currIndeks);
    }
}
