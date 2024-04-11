import javax.swing.*;
import java.awt.*;

public class MatheroWindow extends JFrame{
    int windowWidth = 1180;
    int windowHeight = 740;
    int sidePanelsWidth = 260;

    public MatheroWindow() {
        JFrame frame = new JFrame();
        initializeFrame(frame);
        insertPanelsToFrame(frame);
        insertIconToFrame(frame);
    }

    private void initializeFrame(JFrame frame) {
        frame.setTitle("Mathero");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(windowWidth, windowHeight);
        frame.setVisible(true);
    }

    private void insertPanelsToFrame(JFrame frame) {
        int midPanelWidth = windowWidth - 2*sidePanelsWidth;

        JPanel leftSidePanel = new JPanel();
        JPanel midMainPanel = new JPanel();
        JPanel rightSidePanel = new JPanel();

        leftSidePanel.setBackground(new Color(186, 186, 186));
        leftSidePanel.setBounds(0, 0, sidePanelsWidth, windowHeight);

        midMainPanel.setBackground(new Color(52, 24, 73));
        midMainPanel.setBounds(sidePanelsWidth, 0, midPanelWidth - 16, windowHeight);

        rightSidePanel.setBackground(new Color(186, 186, 186));
        rightSidePanel.setBounds(windowWidth - sidePanelsWidth - 16, 0, sidePanelsWidth, windowHeight);

        frame.add(leftSidePanel);
        frame.add(midMainPanel);
        frame.add(rightSidePanel);
    }

    private void insertIconToFrame(JFrame frame) {
        ImageIcon img = new ImageIcon("gallery/icon.png");
        frame.setIconImage(img.getImage());
    }
}