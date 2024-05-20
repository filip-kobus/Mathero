import Auth.User.User;
import Auth.User.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuthDisplay {
    private  static CardLayout cardLayout = new CardLayout();
    private static JButton loginBtn;
    private static JButton signInBtn;

    public static User user;

    static User getUser() {
        return user;
    }


    public static void displayAuthentication(JPanel upperSection, JPanel lowerSection) {
        JPanel loginPanel = createLoginPanel(upperSection);
        JPanel signInPanel = createSignInPanel();

        upperSection.setLayout(cardLayout);
        upperSection.add(loginPanel, "login");
        upperSection.add(signInPanel, "signIn");

        cardLayout.show(upperSection, "login");

        loginBtn = new JButton("Login Page");
        signInBtn = new JButton("Sign In Page");
        loginBtn.setPreferredSize(new Dimension(150, 40));
        signInBtn.setPreferredSize(new Dimension(150, 40));

        signInBtn.addActionListener(e -> cardLayout.show(upperSection, "signIn"));
        loginBtn.addActionListener(e -> cardLayout.show(upperSection, "login"));

        lowerSection.add(signInBtn);
        lowerSection.add(loginBtn);
    }

    public static JPanel createLoginPanel(JPanel upperSection) {
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(52, 24, 73));
        loginPanel.setLayout(new GridBagLayout());

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 40));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton loginBtn = new JButton("Login");
        loginBtn.setPreferredSize(new Dimension(150, 40));

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                handleLogin(username, password, upperSection);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

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

        gbc.gridy = 4;
        loginPanel.add(loginBtn, gbc);

        return loginPanel;
    }

    public static JPanel createSignInPanel() {
        JPanel signInPanel = new JPanel();
        signInPanel.setBackground(new Color(52, 24, 73));
        signInPanel.setLayout(new GridBagLayout());

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 40));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 40));
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 24));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton signBtn = new JButton("Sign in");
        signBtn.setPreferredSize(new Dimension(150, 40));

        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                handleSignIn(username, email, password);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

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

        gbc.gridy = 6;
        signInPanel.add(signBtn, gbc);

        return signInPanel;
    }

    private static UserService userService = new UserService();

    private static void handleLogin(String username, String password, JPanel upperSection) {
       user = userService.getUserByLogin(username, password);
        if (user != null) {



            JOptionPane.showMessageDialog(null, "Login successful!");
            loginBtn.setVisible(false);
            signInBtn.setVisible(false);
            MatheroApp.switchToTaskPanel();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

    private static void handleSignIn(String username, String email, String password) {
        User user = new User(username, email, password);
        if (userService.saveUser(user)) {
            JOptionPane.showMessageDialog(null, "Sign-in successful! Username: " + username + ", Email: " + email);
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong :( Sign-in failed! Username or Email already exists.");
        }
    }
}
