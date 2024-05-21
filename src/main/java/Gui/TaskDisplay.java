package Gui;

import GeneratorZadan.Generator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskDisplay {
    private static JLabel[] exerciseField = {
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel("")
    };

    private static NumberInputField answerField;
    private static int propperAnswer;
    private static ArrayList<String> exercise;
    private static final ArrayList<ArrayList<String>> allExercise = new ArrayList<>();

    public static void setTaskContent(JPanel taskPanel) {
        answerField = new NumberInputField(2);  // Initialize answerField

        RoundedButton previousExerciseBtn = new RoundedButton("<<", 30);
        RoundedButton checkAnswerBtn = new RoundedButton("Check", 30);
        checkAnswerBtn.styleCheckButton();
        RoundedButton nextExerciseBtn = new RoundedButton(">>", 30);

        nextExerciseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newExercise();
            }
        });

        checkAnswerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = answerField.getText();
                if (!answerText.isEmpty()) {
                    int userAnswer = Integer.parseInt(answerText);
                    if(userAnswer == propperAnswer) {
                        JOptionPane.showMessageDialog(taskPanel, "Odpowiedź poprawna :)");
                        newExercise();
                    }
                    else {
                        JOptionPane.showMessageDialog(taskPanel, "Błędna odpowiedź :(");
                        answerField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(taskPanel, "Proszę wpisać liczbę!!!");
                }
            }
        });

        previousExerciseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousExercise();
            }
        });


        taskPanel.setLayout(new BorderLayout());
        taskPanel.setBackground(new Color(52, 24, 73));

        int windowHeight = taskPanel.getSize().height;
        int transparentPanelHeight = windowHeight / 2 - 100;

        JPanel transparentPanel = new JPanel();
        transparentPanel.setOpaque(false);
        transparentPanel.setPreferredSize(new Dimension(10, transparentPanelHeight));

        taskPanel.add(transparentPanel, BorderLayout.NORTH);

        JPanel labelPanel = new JPanel();
        labelPanel.setOpaque(false);
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        int dzialanie = Generator.generuj_dzialanie();
        exercise = Generator.generuj_zadanie(dzialanie);

        for(int i = 0; i < 5; i++) {
            if(i < 2) {
                exerciseField[i].setText(exercise.get(i));
                exerciseField[i].setForeground(Color.WHITE);
                exerciseField[i].setFont(new Font("Segoe UI Black", Font.BOLD, 60));
                labelPanel.add(exerciseField[i]);
            }
            else if(i == 2) {
                propperAnswer = Integer.parseInt(exercise.get(i));
                labelPanel.add(answerField);
            }
            else {
                exerciseField[i-1].setText(exercise.get(i));
                exerciseField[i-1].setForeground(Color.WHITE);
                exerciseField[i-1].setFont(new Font("Segoe UI Black", Font.BOLD, 60));
                labelPanel.add(exerciseField[i-1]);
            }
        }

        taskPanel.add(labelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(previousExerciseBtn);
        buttonPanel.add(checkAnswerBtn);
        buttonPanel.add(nextExerciseBtn);
        taskPanel.add(buttonPanel, BorderLayout.SOUTH);

        taskPanel.revalidate();
        taskPanel.repaint();
    }

    private static void newExercise() {
        allExercise.add(exercise);
        answerField.setText("");
        int dzialanie = Generator.generuj_dzialanie();
        exercise = Generator.generuj_zadanie(dzialanie);

        for(int i = 0; i < 5; i++) {
            if(i < 2) {
                exerciseField[i].setText(exercise.get(i));
            }
            else if(i > 2) {
                exerciseField[i-1].setText(exercise.get(i));
            }
        }
        propperAnswer =  Integer.parseInt(exercise.get(2));
    }

    private static void previousExercise() {
        int lastElementIndex = allExercise.size() - 1;
        if(lastElementIndex < 0) return;
        exercise = allExercise.get(lastElementIndex);
        allExercise.remove(lastElementIndex);
        answerField.setText("");

        for(int i = 0; i < 5; i++) {
            if(i < 2) {
                exerciseField[i].setText(exercise.get(i));
            }
            else if(i > 2) {
                exerciseField[i-1].setText(exercise.get(i));
            }
        }
        propperAnswer =  Integer.parseInt(exercise.get(2));
    }
}
