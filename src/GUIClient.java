import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;


public class GUIClient implements ActionListener {
    JDBC jdbc = new JDBC();
    GUILogin guiLogin;

    JFrame frame;
    JPanel panel;

    JLabel uploadFileLabel;
    JFileChooser uploadFileChooser;

    JButton logoutButton;

    public void GUI() {
        frame = new JFrame();
        panel = new JPanel();

        uploadFileLabel = new JLabel("Upload an image : ");
        uploadFileChooser = new JFileChooser();

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e ->
        {
            guiLogin = new GUILogin();
            guiLogin.GUI();
            frame.dispose();
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50 , 50, 50, 100));
        panel.setLayout(new GridLayout(6, 2));

        panel.add(uploadFileLabel);
        panel.add(uploadFileChooser);
        panel.add(logoutButton);

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
