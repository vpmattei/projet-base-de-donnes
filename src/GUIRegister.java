import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class GUIRegister implements ActionListener {
    JDBC jdbc = new JDBC();
    GUILogin guiLogin;
    GUIClient guiClient;
    Client loggedClient;

    JFrame frame;
    JPanel panel;
    GroupLayout layout;

    JLabel registerMessage;
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

        registerMessage = new JLabel("Fill in your information");

        nameLabel = new JLabel("First Name : ");
        name = new JTextField(20);

        lastNameLabel = new JLabel("Last Name : ");
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
                loggedClient = jdbc.registerNewClient(name.getText(), lastName.getText(), mail.getText(), password.getText(), postalAddress.getText());
                guiClient = new GUIClient(loggedClient);
                guiClient.GUI();
                frame.dispose();
            }
            else {
                registerMessage.setText("Complete each text field in order to register");
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50 , 50, 50, 50));
        layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        // Putting the labels in a parallel group along the horizontal axis
        // positions them at the same x location.
        //
        // Variable indentation is used to reinforce the level of grouping.
        hGroup.addGroup(layout.createParallelGroup().
                        addComponent(registerMessage).addComponent(nameLabel).addComponent(lastNameLabel).addComponent(postalAddressLabel).addComponent(mailLabel).addComponent(pwdLabel).addComponent(loginButton));
        hGroup.addGroup(layout.createParallelGroup().
                        addComponent(name).addComponent(lastName).addComponent(postalAddress).addComponent(mail).addComponent(password).addComponent(registerButton));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains two parallel groups that align
        // the contents along the baseline. The first parallel group contains
        // the first label and text field, and the second parallel group contains
        // the second label and text field. By using a sequential group
        // the labels and text fields are positioned vertically after one another.
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(registerMessage));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(nameLabel).addComponent(name));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(lastNameLabel).addComponent(lastName));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(postalAddressLabel).addComponent(postalAddress));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(mailLabel).addComponent(mail));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(pwdLabel).addComponent(password));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(loginButton).addComponent(registerButton));
        layout.setVerticalGroup(vGroup);

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
