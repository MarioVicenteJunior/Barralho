import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SistemaLogin {
    private static final String caminho = "dados_user.txt"; // File to store user data

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;

    public SistemaLogin() {
        // Initialize components
        frame = new JFrame("Sistema de Login");
        panel = new JPanel();
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Registo");
        loginButton = new JButton("Login");

        // Set panel layout
        panel.setLayout(new GridLayout(4, 2));

        // Add components to panel
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(loginButton);

        // Add panel to frame
        frame.add(panel);

        // Register button action listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Login button action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor insira o username e password.");
            return;
        }

        // Check if the user already exists
        if (userExists(username)) {
            JOptionPane.showMessageDialog(frame, "O user já existe. Por favor escolha um username diferente.");
            return;
        }

        // Save user data to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho, true))) {
            writer.println(username + "," + password);
            writer.flush();
            JOptionPane.showMessageDialog(frame, "User registado com sucesso.");
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Oops.. ocorreu um erro ao registar o user.");
            e.printStackTrace();
        }
    }

    private void loginUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor insira o username e password.");
            return;
        }

        // Check if the user exists and password is correct
        if (authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(frame, "Login com sucesso!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalido username ou password.");
        }
    }

    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaLogin();
            }
        });
    }
}
