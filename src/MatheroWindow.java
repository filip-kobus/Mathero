import javax.swing.*;
import java.awt.*;

public class MatheroWindow extends JFrame {

    private JPanel MainPanel = new JPanel();
    private JPanel MidPanel = new JPanel();
    private JPanel RightPanel = new JPanel();
    private JPanel LeftPanel = new JPanel();

    JPanel upperSection = new JPanel();
    JPanel lowerSection = new JPanel();

    private GridBagConstraints gbc = new GridBagConstraints();

    public MatheroWindow() {
        addSection();
        setZadanie();
        setBackground();
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

        this.setContentPane(MainPanel);

        this.setTitle("Mathero");
        this.setSize(1180, 740);
        this.setVisible(true);
        this.setResizable(false);
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
        //gbc.weightx = 1.0;
        gbc.weighty = 1.0; // Set weighty to 0.5 for equal distribution of space

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

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(50, 60));
        //answerField.setMinimumSize(answerField.getPreferredSize());
        //answerField.setMaximumSize(answerField.getPreferredSize());
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

        upperSection.add(firstTextField);
        upperSection.add(answerField);
        upperSection.add(secondTextField);

        lowerSection.add(previousExerciseBtn);
        lowerSection.add(checkAnswerBtn);
        lowerSection.add(nextExerciseBtn);
    }

}
