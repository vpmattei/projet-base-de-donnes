import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class GUILogin implements ActionListener {
    JDBC jdbc = new JDBC();
    GUIRegister guiRegister;
    GUIClient guiClient;
    Client loggedClient;

    JFrame frame;
    JPanel panel;
    GroupLayout layout;

    JLabel mailLabel;
    JLabel pwdLabel;

    JLabel loginMessage;

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

        loginMessage = new JLabel("Type your login credentials or register a new account :)");

        loginButton = new JButton("Login");
        loginButton.addActionListener(e ->
        {
            try {
                loggedClient = jdbc.loginClient(mail.getText(), password.getText());
                if (loggedClient != null) {
                    guiClient = new GUIClient(loggedClient);
                    guiClient.GUI();
                    frame.dispose();
                }
            }
            catch (NullPointerException npe) {
                loginMessage.setText("Wrong credentials!");
                npe.printStackTrace();
            }
            
        });

        registerButton = new JButton("Register Here");
        registerButton.addActionListener(e -> 
        {
            guiRegister = new GUIRegister();
            guiRegister.GUI();
            frame.dispose();
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
                        addComponent(loginMessage).addComponent(mailLabel).addComponent(pwdLabel).addComponent(loginButton));
        hGroup.addGroup(layout.createParallelGroup().
                        addComponent(mail).addComponent(password).addComponent(registerButton));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains two parallel groups that align
        // the contents along the baseline. The first parallel group contains
        // the first label and text field, and the second parallel group contains
        // the second label and text field. By using a sequential group
        // the labels and text fields are positioned vertically after one another.
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(loginMessage));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(mailLabel).addComponent(mail));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(pwdLabel).addComponent(password));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                        addComponent(loginButton).addComponent(registerButton));
        layout.setVerticalGroup(vGroup);

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
