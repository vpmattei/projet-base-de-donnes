import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.*;


public class GUILogin implements ActionListener {
    JDBC jdbc = new JDBC();
    GUIRegister guiRegister;
    GUIClient guiClient;

    JFrame frame;
    JPanel panel;

    JLabel mailLabel;
    JLabel pwdLabel;

    JTextField mail;
    JPasswordField password;

    JButton loginButton;
    JButton registerButton;

    public void GUI() {
        frame = new JFrame();
        panel = new JPanel();

        mailLabel = new JLabel("E-Mail : ");
        mail = new JTextField(20);

        pwdLabel = new JLabel("Password : ");
        password = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(e ->
        {
            if (jdbc.loginClient(mail.getText(), password.getText()) != null) {
                guiClient = new GUIClient();
                guiClient.GUI();
                frame.dispose();
            }
            else {
                // Error message
            }
        }
        );

        registerButton = new JButton("Register Here");
        registerButton.addActionListener(e -> 
        {
            guiRegister = new GUIRegister();
            guiRegister.GUI();
            frame.dispose();
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50 , 50, 50, 100));
        panel.setLayout(new GridLayout(3, 2));

        panel.add(mailLabel);
        panel.add(mail);
        panel.add(pwdLabel);
        panel.add(password);

        panel.add(loginButton);
        panel.add(registerButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
