import javax.swing.*;
import java.awt.*;


public class AuthDisplay {
    private static CardLayout cardLayout = new CardLayout();

    public static void displayAuthentication(JPanel upperSection, JPanel lowerSection) {
        JPanel loginPanel = createLoginPanel();
        JPanel signInPanel = createSignInPanel();

        upperSection.setLayout(cardLayout);
        upperSection.add(loginPanel, "login");
      upperSection.add(signInPanel, "signIn");

        cardLayout.show(upperSection, "login");


        JButton loginBtn = new JButton("Login");
        JButton signInBtn = new JButton("Sign In");
        loginBtn.setPreferredSize(new Dimension(200, 60));
        signInBtn.setPreferredSize(new Dimension(200, 60));

        signInBtn.addActionListener(e -> cardLayout.show(upperSection, "signIn"));

        loginBtn.addActionListener(e -> cardLayout.show(upperSection, "login"));

        lowerSection.add(signInBtn);
        lowerSection.add(loginBtn);

    }

    public static JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(52, 24, 73));
        loginPanel.setLayout(new GridBagLayout());

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(400, 80));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 36));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(400, 80));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 36));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 40));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 40));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to loginPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridy = 3;
        loginPanel.add(passwordField, gbc);


        return loginPanel;
    }


    public static JPanel createSignInPanel() {
        JPanel signInPanel = new JPanel();
        signInPanel.setBackground(new Color(52, 24, 73));
        signInPanel.setLayout(new GridBagLayout());

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(400, 80));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 36));

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 80));
        emailField.setFont(new Font("Arial", Font.PLAIN, 36));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(400, 80));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 36));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 40));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 40));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 40));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to signInPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signInPanel.add(usernameLabel, gbc);


        gbc.gridy = 1;
        gbc.gridwidth = 1;
        signInPanel.add(usernameField, gbc);


        gbc.gridy = 2;
        gbc.gridwidth = 2;
        signInPanel.add(emailLabel, gbc);

        gbc.gridy = 3;
        signInPanel.add(emailField, gbc);


        gbc.gridy = 4;
        signInPanel.add(passwordLabel, gbc);


        gbc.gridy = 5;
        signInPanel.add(passwordField, gbc);

        return signInPanel;
    }

}
