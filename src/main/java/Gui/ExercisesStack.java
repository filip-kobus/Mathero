package Gui;

import java.util.ArrayList;

public class ExercisesStack {
    private final ArrayList<ArrayList<String>> allExercise;
    private int currIndeks;

    public ExercisesStack() {
        this.allExercise = new ArrayList<>();
        this.currIndeks = -1;
    }

    public ArrayList<String> getPrevious() {
        if (currIndeks <= 0) {
            return allExercise.get(currIndeks);
        }
        currIndeks--;
        return allExercise.get(currIndeks);
    }

    public void push(ArrayList<String> element) {
        if(currIndeks == allExercise.size() - 1) allExercise.add(element);
        currIndeks++;
    }

    public ArrayList<String> getExercise() {
        if (currIndeks >= 0) {
            return allExercise.get(currIndeks);
        }
        return null;
    }
}
