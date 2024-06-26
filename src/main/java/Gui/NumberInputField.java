package Gui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class NumberInputField extends JTextField {

    public NumberInputField(int maxLength) {
        super();
        setDocument(createNumberDocument(maxLength));
        setPreferredSize(new Dimension(maxLength * 38, 60));
        setBackground(new Color(52, 24, 73));
        setForeground(Color.WHITE);
        // Set a border only on the south side (bottom)
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        setFont(new Font("Segoe UI Black", Font.BOLD, 60));
        setHorizontalAlignment(JTextField.CENTER);
        setCaretColor(Color.WHITE);
    }

    private Document createNumberDocument(int maxLength) {
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new NumberDocumentFilter(maxLength));
        return doc;
    }
}
