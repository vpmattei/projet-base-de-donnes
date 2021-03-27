import java.io.File;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUIClient extends JFrame {
    private GUILogin guiLogin;
    private Client loggedClient;

    private JPanel backgroundPanel;
    private JPanel bluePanel;
    private JLabel clientNameLabel;
    private JFileChooser jFileChooser1;
    private JButton logoutButton;
    private JButton browseButton;
    
    // Image
    JFrame imageFrame;
    JLabel imageLabel;
    BufferedImage img;
    ImageIcon icon;
    
     public GUIClient(Client client) {
        this.loggedClient = client;
    }

    public void GUI() {
        backgroundPanel = new JPanel();
        bluePanel = new JPanel();
        clientNameLabel = new JLabel();
        
        logoutButton = new JButton();
        browseButton = new JButton();

        imageLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 204));

        bluePanel.setBackground(new java.awt.Color(153, 153, 255));
        bluePanel.setPreferredSize(new java.awt.Dimension(114, 50));

        clientNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clientNameLabel.setText("Client : " + loggedClient.name() + " " + loggedClient.lastName());

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        browseButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        browseButton.setText("Browse");
        browseButton.addActionListener(e ->
        {
            jFileChooser1 = new JFileChooser();
            jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int res = jFileChooser1.showOpenDialog(null);
            // We have an image!
            try {
                if (res == JFileChooser.APPROVE_OPTION) {
                    // Choose and read imgFile
                    File file = jFileChooser1.getSelectedFile();
                    img = ImageIO.read(file);
                    // Create new frame and label for the image
                    icon = new ImageIcon(img);
                    imageFrame = new JFrame();
                    imageFrame.setSize(1500,1800);
                    imageLabel = new JLabel(icon);
                    // Show image
                    imageFrame.add(imageLabel);
                    imageFrame.setVisible(true);
                    imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } // Oops!
                else {
                    JOptionPane.showMessageDialog(null,
                            "You must select one image to be the reference.", "Aborting...",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception iOException) {
                iOException.printStackTrace();
            }
        });

        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(e ->
        {
            guiLogin = new GUILogin();
            guiLogin.GUI();
            this.dispose();
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bluePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(browseButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 523, Short.MAX_VALUE)
                        .addComponent(logoutButton)
                        .addContainerGap())))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(browseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setVisible(true);
    }

    
}
