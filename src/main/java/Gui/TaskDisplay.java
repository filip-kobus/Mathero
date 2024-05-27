package Gui;

import GeneratorZadan.Generator;
import Main.MatheroApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class TaskDisplay {
    private static final JLabel[] exerciseField = {
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel("")
    };

    private static NumberInputField answerField;
    private static int propperAnswer;
    private static final ExercisesStack stack = new ExercisesStack();
    private static int streak = 0;

    public static void setTaskContent(JPanel taskPanel) {
        answerField = new NumberInputField(2);

        RoundedButton previousExerciseBtn = new RoundedButton("<<", 30);
        RoundedButton checkAnswerBtn = new RoundedButton("Check", 30);
        checkAnswerBtn.styleCheckButton();
        RoundedButton nextExerciseBtn = new RoundedButton(">>", 30);

        JFrame frame = MatheroApp.getFrame();
        frame.getRootPane().setDefaultButton(checkAnswerBtn);
        nextExerciseBtn.addActionListener(e -> newExercise());

        JLabel streakLabel = new JLabel("Streak: " + Integer.toString(streak));

        checkAnswerBtn.addActionListener(e -> {
            String answerText = answerField.getText();
            if (!answerText.isEmpty()) {
                int userAnswer = Integer.parseInt(answerText);
                if(userAnswer == propperAnswer) {
                    JOptionPane.showMessageDialog(taskPanel, "Odpowiedź poprawna :)");
                    newExercise();
                    streak++;
                    streakLabel.setText("Streak: " + Integer.toString(streak));
                }
                else {
                    JOptionPane.showMessageDialog(taskPanel, "Błędna odpowiedź :(");
                    answerField.setText("");
                    streak = 0;
                    streakLabel.setText("Streak: " + Integer.toString(streak));
                }
            } else {
                JOptionPane.showMessageDialog(taskPanel, "Proszę wpisać liczbę!!!");
            }
        });

        previousExerciseBtn.addActionListener(e -> previousExercise());


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
        stack.push(Generator.generuj_zadanie(dzialanie));
        ArrayList<String> exercise = stack.getExercise();

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

        JPanel streakPanel = new JPanel(new FlowLayout());
        streakPanel.add(streakLabel);
        taskPanel.add(streakPanel, BorderLayout.NORTH);

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
        int dzialanie = Generator.generuj_dzialanie();
        stack.push(Generator.generuj_zadanie(dzialanie));
        ArrayList<String> exercise = stack.getExercise();
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

    private static void previousExercise() {
        ArrayList<String> exercise = stack.getPrevious();;
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
