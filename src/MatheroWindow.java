import javax.swing.*;

public class MatheroWindow extends JFrame {
    private JPanel Background;
    private JPanel SidePanelLeft;
    private JPanel SidePanelRight;

    public MatheroWindow() {
        setBackground();
        setSidePanels();
    }

    private void setBackground() {
        this.setContentPane(this.Background);
        this.setTitle("Mathero");
        this.setSize(1180, 740);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void setSidePanels() {
        this.add(SidePanelLeft);
        this.add(SidePanelRight);
    }
}
