import javax.swing.*;
import java.awt.*;

public class MatHeroApp extends JFrame {

    private JPanel MainPanel = new JPanel();
    private JPanel MidPanel = new JPanel();
    private JPanel RightPanel = new JPanel();
    private JPanel LeftPanel = new JPanel();

    JPanel upperSection = new JPanel();
    JPanel lowerSection = new JPanel();

    private GridBagConstraints gbc = new GridBagConstraints();

    public MatHeroApp() {
        addSection();
        AuthDisplay.displayAuthentication(upperSection, lowerSection);
        setBackground();
    }

    private void setBackground() {
        MainPanel.setLayout(new BorderLayout());

        LeftPanel.setPreferredSize(new Dimension(260, MainPanel.getHeight()));
        LeftPanel.setBackground(new Color(186, 186, 186));

        RightPanel.setPreferredSize(new Dimension(260, MainPanel.getHeight()));
        RightPanel.setBackground(new Color(186, 186, 186));

        MainPanel.add(LeftPanel, BorderLayout.WEST);
        MainPanel.add(MidPanel, BorderLayout.CENTER);
        MainPanel.add(RightPanel, BorderLayout.EAST);

        this.setContentPane(MainPanel);

        this.setTitle("Mathero");
        this.setSize(1180, 740);
        this.setVisible(true);
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



    public static void main(String[] args) {
        new MatHeroApp();
    }

}
