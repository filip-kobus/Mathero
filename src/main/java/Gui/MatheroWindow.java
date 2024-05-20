package Gui;

import javax.swing.*;
import java.awt.*;

public class MatheroWindow extends JFrame {

    private final JPanel MainPanel = new JPanel();
    private final JPanel MidPanel = new JPanel();
    private final JPanel RightPanel = new JPanel();
    private final JPanel LeftPanel = new JPanel();

    JPanel upperSection = new JPanel();
    JPanel lowerSection = new JPanel();

    public MatheroWindow() {
        addSection();
        setZadanie();
        setBackground();

        setContentPane(MainPanel);

        setTitle("Mathero");
        ImageIcon icon = new ImageIcon("gallery/icon.png");
        setIconImage(icon.getImage());
        setSize(1180, 740);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addSection() {
        MidPanel.setBackground(new Color(52, 24, 73));
        MidPanel.setLayout(new GridBagLayout());

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
        MidPanel.add(upperSection, gbc);

        // Add lowerSection to MidPanel
        gbc.gridy = 1;
        MidPanel.add(lowerSection, gbc);
    }

    private void setZadanie() {
        JLabel firstTextField = new JLabel("2 + ");
        firstTextField.setForeground(Color.WHITE);
        firstTextField.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

        JLabel secondTextField = new JLabel(" = 5");
        secondTextField.setForeground(Color.WHITE);
        secondTextField.setFont(new Font("Segoe UI Black", Font.BOLD, 60));

        NumberInputField answerField = new NumberInputField(3);

        RoundedButton previousExerciseBtn = new RoundedButton("<<");
        RoundedButton checkAnswerBtn = new RoundedButton("Check");
        checkAnswerBtn.styleCheckButton();
        RoundedButton nextExerciseBtn = new RoundedButton(">>");

        upperSection.add(firstTextField);
        upperSection.add(answerField);
        upperSection.add(secondTextField);

        lowerSection.add(previousExerciseBtn);
        lowerSection.add(checkAnswerBtn);
        lowerSection.add(nextExerciseBtn);
    }

    private void setBackground() {
        MainPanel.setLayout(new BorderLayout());

        LeftPanel.setPreferredSize(new Dimension(260, MainPanel.getHeight()));
        LeftPanel.setBackground(new Color(186, 186, 186));

        RightPanel.setPreferredSize(new Dimension(260, MainPanel.getHeight()));
        RightPanel.setBackground(new Color(186, 186, 186));

        // Dodawanie LeftPanel, MidPanel i RightPanel do MainPanel
        MainPanel.add(LeftPanel, BorderLayout.WEST);
        MainPanel.add(MidPanel, BorderLayout.CENTER);
        MainPanel.add(RightPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new MatheroWindow();
    }
}
