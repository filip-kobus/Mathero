package Gui;

import javax.swing.*;
import java.awt.*;

public class TaskDisplay {

    public static void setTaskContent(JPanel taskPanel) {

        JLabel equationLabel = new JLabel("2 + ");
        equationLabel.setForeground(Color.WHITE);
        equationLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

        JLabel resultLabel = new JLabel(" = 5");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(50, 60));
        answerField.setBackground(new Color(52, 24, 73));
        answerField.setForeground(Color.WHITE);
        answerField.setFont(new Font("Arial", Font.PLAIN, 60));
        answerField.setCaretPosition(0);

        JButton previousExerciseBtn = new JButton("<<");
        previousExerciseBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        previousExerciseBtn.setPreferredSize(new Dimension(190, 150));

        JButton checkAnswerBtn = new JButton("Check");
        checkAnswerBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        checkAnswerBtn.setPreferredSize(new Dimension(190, 150));

        JButton nextExerciseBtn = new JButton(">>");
        nextExerciseBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        nextExerciseBtn.setPreferredSize(new Dimension(190, 150));

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
        labelPanel.add(equationLabel);
        labelPanel.add(answerField);
        labelPanel.add(resultLabel);
        taskPanel.add(labelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(previousExerciseBtn);
        buttonPanel.add(checkAnswerBtn);
        buttonPanel.add(nextExerciseBtn);
        taskPanel.add(buttonPanel, BorderLayout.SOUTH);

        taskPanel.revalidate();
        taskPanel.repaint();
    }
}
