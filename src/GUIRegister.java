import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;


public class GUIRegister implements ActionListener {
    JDBC jdbc = new JDBC();
    GUILogin guiLogin;
    GUIClient guiClient;

    JFrame frame;
    JPanel panel;

    JLabel nameLabel;
    JLabel lastNameLabel;
    JLabel mailLabel;
    JLabel pwdLabel;
    JLabel postalAddressLabel;

    JTextField name;
    JTextField lastName;
    JTextField mail;
    JPasswordField password;
    JTextField postalAddress;

    JButton registerButton;
    JButton loginButton;

    public void GUI() {
        frame = new JFrame();
        panel = new JPanel();

        nameLabel = new JLabel("Prènom : ");
        name = new JTextField(20);

        lastNameLabel = new JLabel("Nom : ");
        lastName = new JTextField(20);

        mailLabel = new JLabel("E-Mail : ");
        mail = new JTextField(20);
        
        pwdLabel = new JLabel("Password : ");
        password = new JPasswordField();

        postalAddressLabel = new JLabel("Postal Address : ");
        postalAddress = new JTextField(20);

        loginButton = new JButton("Login Here");
        loginButton.addActionListener(e ->
        {
            guiLogin = new GUILogin();
            guiLogin.GUI();
            frame.dispose();
        });

        registerButton = new JButton("Register");
        registerButton.addActionListener(e ->
        {
            if (name.getText().length() > 0 && lastName.getText().length() > 0 && mail.getText().length() > 0 && password.getText().length() > 0 && postalAddress.getText().length() > 0) {
                jdbc.registerNewClient(name.getText(), lastName.getText(), mail.getText(), password.getText(), postalAddress.getText());
                guiClient = new GUIClient();
                guiClient.GUI();
                frame.dispose();
            }
            else {
                // Complete form
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50 , 50, 50, 100));
        panel.setLayout(new GridLayout(6, 2));

        panel.add(nameLabel);
        panel.add(name);

        panel.add(lastNameLabel);
        panel.add(lastName);

        panel.add(postalAddressLabel);
        panel.add(postalAddress);

        panel.add(mailLabel);
        panel.add(mail);

        panel.add(pwdLabel);
        panel.add(password);

        panel.add(registerButton);
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Register");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
