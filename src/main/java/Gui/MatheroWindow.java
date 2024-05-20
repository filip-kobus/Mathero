package Gui;

import GeneratorZadan.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MatheroWindow extends JFrame {

    private final JPanel mainPanel = new JPanel();
    private final JPanel midPanel = new JPanel();
    private final JPanel rightPanel = new JPanel();
    private final JPanel leftPanel = new JPanel();
    private JLabel[] exerciseField = {
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel("")
    };

    JPanel upperSection = new JPanel();
    JPanel lowerSection = new JPanel();

    private NumberInputField answerField;
    private String answerX;

    public MatheroWindow() {
        addSection();
        initExercisePage();
        setBackground();

        setContentPane(mainPanel);

        setTitle("Mathero");
        ImageIcon icon = new ImageIcon("gallery/icon.png");
        setIconImage(icon.getImage());
        setSize(1180, 740);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addSection() {
        midPanel.setBackground(new Color(52, 24, 73));
        midPanel.setLayout(new GridBagLayout());

        upperSection.setBackground(new Color(52, 24, 73)); // Set background color if needed
        upperSection.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200)); // Center the FlowLayout horizontally

        lowerSection.setBackground(new Color(52, 24, 73)); // Set background color if needed
        lowerSection.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Center the FlowLayout horizontally

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0; // Set weighty to 1.0 for equal distribution of space

        // Add upperSection to MidPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        midPanel.add(upperSection, gbc);

        // Add lowerSection to MidPanel
        gbc.gridy = 1;
        midPanel.add(lowerSection, gbc);
    }

    private void newExercise() {
        answerField.setText("");
        int dzialanie = Generator.generuj_dzialanie();
        ArrayList<String> exercise = Generator.generuj_zadanie(dzialanie);

        for(int i = 0; i < 5; i++) {
            if(i < 2) {
                exerciseField[i].setText(exercise.get(i));
            }
            else if(i > 2) {
                exerciseField[i-1].setText(exercise.get(i));
            }
        }
        answerX = exercise.get(2);
    }

    private boolean checkAnswer(int answer) {
        int pomoc = Integer.parseInt(answerX);
        boolean b = answer == pomoc;
        return b;
    }

    private void initExercisePage() {
        answerField = new NumberInputField(2);  // Initialize answerField

        RoundedButton previousExerciseBtn = new RoundedButton("<<");
        RoundedButton checkAnswerBtn = new RoundedButton("Check");
        checkAnswerBtn.styleCheckButton();
        RoundedButton nextExerciseBtn = new RoundedButton(">>");

        nextExerciseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newExercise(); // Call the newExercise() method
            }
        });

        checkAnswerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = answerField.getText();
                int answerInt = Integer.parseInt(answerText);
                if (!answerText.isEmpty()) {
                    if(checkAnswer(answerInt)) JOptionPane.showMessageDialog(mainPanel, "Odpowiedź poprawna :)");
                    else JOptionPane.showMessageDialog(mainPanel, "Błędna odpowiedź :(");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Proszę wpisać liczbę!!!");
                }
            }
        });

        int dzialanie = Generator.generuj_dzialanie();
        ArrayList<String> exercise = Generator.generuj_zadanie(dzialanie);

        for(int i = 0; i < 5; i++) {
            if(i < 2) {
                exerciseField[i].setText(exercise.get(i));
                exerciseField[i].setForeground(Color.WHITE);
                exerciseField[i].setFont(new Font("Segoe UI Black", Font.BOLD, 60));
                upperSection.add(exerciseField[i]);
            }
            else if(i == 2) {
                answerX = exercise.get(i);
                upperSection.add(answerField);
            }
            else {
                exerciseField[i-1].setText(exercise.get(i));
                exerciseField[i-1].setForeground(Color.WHITE);
                exerciseField[i-1].setFont(new Font("Segoe UI Black", Font.BOLD, 60));
                upperSection.add(exerciseField[i-1]);
            }
        }

        lowerSection.add(previousExerciseBtn);
        lowerSection.add(checkAnswerBtn);
        lowerSection.add(nextExerciseBtn);
    }

    private void setBackground() {
        mainPanel.setLayout(new BorderLayout());

        leftPanel.setPreferredSize(new Dimension(260, mainPanel.getHeight()));
        leftPanel.setBackground(new Color(186, 186, 186));

        rightPanel.setPreferredSize(new Dimension(260, mainPanel.getHeight()));
        rightPanel.setBackground(new Color(186, 186, 186));

        // Dodawanie LeftPanel, MidPanel i RightPanel do MainPanel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new MatheroWindow();
    }
}

