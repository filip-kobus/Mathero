import javax.swing.*;
import java.awt.*;

public class MatheroApp {
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel mainPanel = new JPanel(cardLayout);


    public static void displayContent(JPanel upperSection, JPanel lowerSection) {
        mainPanel.setLayout(cardLayout);


        JPanel authPanel = new JPanel();
        JPanel taskPanel = new JPanel();

        mainPanel.add(authPanel, "auth");
        mainPanel.add(taskPanel, "task");

        AuthDisplay.displayAuthentication(authPanel, lowerSection);


        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setBackground(new Color(220, 220, 220));
        leftSidePanel.setPreferredSize(new Dimension(200, 0));
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setBackground(new Color(220, 220, 220));
        rightSidePanel.setPreferredSize(new Dimension(200, 0));

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(leftSidePanel, BorderLayout.WEST);
        contentPane.add(rightSidePanel, BorderLayout.EAST);

        JFrame frame = new JFrame("MatHeroApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setContentPane(contentPane);
        frame.add(lowerSection, BorderLayout.SOUTH);
        frame.setVisible(true);

        cardLayout.show(mainPanel, "auth");
    }

    public static void switchToTaskPanel() {
        TaskDisplay.setTaskContent(getTaskPanel());
        cardLayout.show(mainPanel, "task");

    }

    public static JPanel getTaskPanel() {
        return (JPanel) mainPanel.getComponent(1);
    }

    public static void main(String[] args) {
        JPanel upperSection = new JPanel(new BorderLayout());
        JPanel lowerSection = new JPanel(new FlowLayout());

        displayContent(upperSection, lowerSection);
    }
}
