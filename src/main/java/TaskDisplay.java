import javax.swing.*;
import java.awt.*;

public class TaskDisplay extends JFrame {


    public static void setZadanie(JPanel upperSection, JPanel lowerSection) {
        JLabel firstTextField = new JLabel("2 + ");
        firstTextField.setForeground(Color.WHITE);
        firstTextField.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

        JLabel secondTextField = new JLabel(" = 5");
        secondTextField.setForeground(Color.WHITE);
        secondTextField.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        upperSection.add(firstTextField, gbc);

        gbc.gridx = 1;
        upperSection.add(answerField, gbc);

        gbc.gridx = 2;
        upperSection.add(secondTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        lowerSection.add(previousExerciseBtn, gbc);

        gbc.gridx = 1;
        lowerSection.add(checkAnswerBtn, gbc);

        gbc.gridx = 2;
        lowerSection.add(nextExerciseBtn, gbc);
    }

}
