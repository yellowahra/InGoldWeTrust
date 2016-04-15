
package ingoldwetrust;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MusketeersGUI extends JFrame {

    Connection conn = null;
    String user = "root";
    String pass = "ingoldwetrust";
    String server;
    
    public MusketeersGUI(String server) throws SQLException{
        initComponents();
        
        this.server = server;
        
        this.setTitle("The Musketeers: " + server);
        this.setSize(780, 438);
        this.setLocationRelativeTo(null);
        noBorder();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://159.203.115.184:3306/" + server, user, pass);
            System.out.println("Database: Connected to " + server);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        homePanel.setVisible(true);
        searchPanel.setVisible(false);
        predictPanel.setVisible(false);
        testingPanel.setVisible(false);
        helpPanel.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpPanel = new javax.swing.JPanel();
        homeButton2 = new javax.swing.JButton();
        searchButton2 = new javax.swing.JButton();
        predictiveButton2 = new javax.swing.JButton();
        testingButton2 = new javax.swing.JButton();
        helpText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        helpInfo = new javax.swing.JTextArea();
        homePanel = new javax.swing.JPanel();
        toprise = new javax.swing.JButton();
        topfall = new javax.swing.JButton();
        mostsell = new javax.swing.JButton();
        leastsell = new javax.swing.JButton();
        serverButton = new javax.swing.JButton();
        itemLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        lookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        predictiveButton = new javax.swing.JButton();
        testingButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        predictPanel = new javax.swing.JPanel();
        testingPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 0));
        getContentPane().setLayout(null);

        helpPanel.setBackground(new java.awt.Color(204, 204, 204));

        homeButton2.setBackground(new java.awt.Color(102, 102, 102));
        homeButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        homeButton2.setForeground(new java.awt.Color(255, 255, 255));
        homeButton2.setText("Home");
        homeButton2.setBorderPainted(false);
        homeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButton2ActionPerformed(evt);
            }
        });

        searchButton2.setBackground(new java.awt.Color(102, 102, 102));
        searchButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchButton2.setForeground(new java.awt.Color(255, 255, 255));
        searchButton2.setText("Search");
        searchButton2.setBorderPainted(false);
        searchButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton2ActionPerformed(evt);
            }
        });

        predictiveButton2.setBackground(new java.awt.Color(102, 102, 102));
        predictiveButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        predictiveButton2.setForeground(new java.awt.Color(255, 255, 255));
        predictiveButton2.setText("Predictive");
        predictiveButton2.setBorderPainted(false);
        predictiveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predictiveButton2ActionPerformed(evt);
            }
        });

        testingButton2.setBackground(new java.awt.Color(102, 102, 102));
        testingButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        testingButton2.setForeground(new java.awt.Color(255, 255, 255));
        testingButton2.setText("Testing");
        testingButton2.setBorderPainted(false);
        testingButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingButton2ActionPerformed(evt);
            }
        });

        helpText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        helpText.setText("Select a button for more information");

        helpInfo.setColumns(20);
        helpInfo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        helpInfo.setLineWrap(true);
        helpInfo.setRows(5);
        jScrollPane2.setViewportView(helpInfo);

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(helpText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(helpPanelLayout.createSequentialGroup()
                        .addComponent(homeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(searchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(predictiveButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(testingButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(helpText)
                .addGap(26, 26, 26)
                .addGroup(helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(predictiveButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testingButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(helpPanel);
        helpPanel.setBounds(170, 0, 610, 410);

        homePanel.setBackground(new java.awt.Color(204, 204, 204));

        toprise.setBackground(new java.awt.Color(0, 102, 51));
        toprise.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        toprise.setForeground(new java.awt.Color(255, 255, 255));
        toprise.setText("Rising");
        toprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topriseActionPerformed(evt);
            }
        });

        topfall.setBackground(new java.awt.Color(102, 0, 0));
        topfall.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        topfall.setForeground(new java.awt.Color(255, 255, 255));
        topfall.setText("Falling");

        mostsell.setBackground(new java.awt.Color(0, 102, 51));
        mostsell.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        mostsell.setForeground(new java.awt.Color(255, 255, 255));
        mostsell.setText("Most Sold");

        leastsell.setBackground(new java.awt.Color(102, 0, 0));
        leastsell.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        leastsell.setForeground(new java.awt.Color(255, 255, 255));
        leastsell.setText("Least Sold");

        serverButton.setBackground(new java.awt.Color(51, 51, 51));
        serverButton.setForeground(new java.awt.Color(255, 255, 255));
        serverButton.setText("New Server");
        serverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverButtonActionPerformed(evt);
            }
        });

        itemLabel.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        itemLabel.setText("Top 10 Items");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostsell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toprise, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topfall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leastsell, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addComponent(serverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addComponent(itemLabel)
                        .addGap(206, 206, 206))))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(itemLabel)
                .addGap(26, 26, 26)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toprise, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topfall, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostsell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leastsell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(serverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(homePanel);
        homePanel.setBounds(170, 0, 610, 410);

        searchPanel.setBackground(new java.awt.Color(204, 204, 204));

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setText("Leather");

        lookButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lookButton.setText("Search");
        lookButton.setBorderPainted(false);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(itemTable);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lookButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(searchPanel);
        searchPanel.setBounds(170, 0, 611, 410);

        buttonPanel.setBackground(new java.awt.Color(0, 0, 0));
        buttonPanel.setLayout(null);

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        homeButton.setForeground(new java.awt.Color(51, 51, 51));
        homeButton.setText("Home");
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(homeButton);
        homeButton.setBounds(0, 0, 170, 80);

        searchButton.setBackground(new java.awt.Color(51, 51, 51));
        searchButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorderPainted(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(searchButton);
        searchButton.setBounds(0, 80, 170, 80);

        predictiveButton.setBackground(new java.awt.Color(51, 51, 51));
        predictiveButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        predictiveButton.setForeground(new java.awt.Color(255, 255, 255));
        predictiveButton.setText("Predictive");
        predictiveButton.setBorderPainted(false);
        predictiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predictiveButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(predictiveButton);
        predictiveButton.setBounds(0, 160, 170, 80);

        testingButton.setBackground(new java.awt.Color(51, 51, 51));
        testingButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        testingButton.setForeground(new java.awt.Color(255, 255, 255));
        testingButton.setText("Testing");
        testingButton.setBorderPainted(false);
        testingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(testingButton);
        testingButton.setBounds(0, 240, 170, 80);

        helpButton.setBackground(new java.awt.Color(51, 51, 51));
        helpButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        helpButton.setForeground(new java.awt.Color(255, 255, 255));
        helpButton.setText("Help");
        helpButton.setBorderPainted(false);
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(helpButton);
        helpButton.setBounds(0, 320, 170, 80);

        getContentPane().add(buttonPanel);
        buttonPanel.setBounds(0, 0, 170, 400);

        predictPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout predictPanelLayout = new javax.swing.GroupLayout(predictPanel);
        predictPanel.setLayout(predictPanelLayout);
        predictPanelLayout.setHorizontalGroup(
            predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        predictPanelLayout.setVerticalGroup(
            predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(predictPanel);
        predictPanel.setBounds(170, 0, 610, 410);

        testingPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout testingPanelLayout = new javax.swing.GroupLayout(testingPanel);
        testingPanel.setLayout(testingPanelLayout);
        testingPanelLayout.setHorizontalGroup(
            testingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        testingPanelLayout.setVerticalGroup(
            testingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(testingPanel);
        testingPanel.setBounds(170, 0, 610, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        homePanel.setVisible(true);
        searchPanel.setVisible(false);
        predictPanel.setVisible(false);
        testingPanel.setVisible(false);
        helpPanel.setVisible(false);
        homeButton.setBackground(new Color(204, 204, 204));
        searchButton.setBackground(new Color(51, 51, 51));
        predictiveButton.setBackground(new Color(51, 51, 51));
        testingButton.setBackground(new Color(51, 51, 51));
        helpButton.setBackground(new Color(51, 51, 51));
        helpButton.setForeground(new Color(204, 204, 204));
        homeButton.setForeground(new Color(51, 51, 51));
        searchButton.setForeground(new Color(204, 204, 204));
        predictiveButton.setForeground(new Color(204, 204, 204));
        testingButton.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_homeButtonActionPerformed

    private void topriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topriseActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchPanel.setVisible(true);
        homePanel.setVisible(false);
        predictPanel.setVisible(false);
        testingPanel.setVisible(false);
        helpPanel.setVisible(false);
        searchButton.setBackground(new Color(204, 204, 204));
        homeButton.setBackground(new Color(51, 51, 51));
        predictiveButton.setBackground(new Color(51, 51, 51));
        testingButton.setBackground(new Color(51, 51, 51));
        helpButton.setBackground(new Color(51, 51, 51));
        helpButton.setForeground(new Color(204, 204, 204));
        homeButton.setForeground(new Color(204, 204, 204));
        searchButton.setForeground(new Color(51, 51, 51));
        predictiveButton.setForeground(new Color(204, 204, 204));
        testingButton.setForeground(new Color(204, 204, 204));
        
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Controller(conn, searchField.getText(), itemTable);
            }
        });
        
        lookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Controller(conn, searchField.getText(), itemTable);
            }
        });
    }//GEN-LAST:event_searchButtonActionPerformed

    private void predictiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictiveButtonActionPerformed
        predictPanel.setVisible(true);
        homePanel.setVisible(false);
        searchPanel.setVisible(false);
        testingPanel.setVisible(false);
        helpPanel.setVisible(false);
        predictiveButton.setBackground(new Color(204, 204, 204));
        homeButton.setBackground(new Color(51, 51, 51));
        searchButton.setBackground(new Color(51, 51, 51));
        testingButton.setBackground(new Color(51, 51, 51));
        helpButton.setBackground(new Color(51, 51, 51));
        helpButton.setForeground(new Color(204, 204, 204));
        homeButton.setForeground(new Color(204, 204, 204));
        searchButton.setForeground(new Color(204, 204, 204));
        predictiveButton.setForeground(new Color(51, 51, 51));
        testingButton.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_predictiveButtonActionPerformed

    private void testingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingButtonActionPerformed
        testingPanel.setVisible(true);
        predictPanel.setVisible(false);
        homePanel.setVisible(false);
        searchPanel.setVisible(false);
        helpPanel.setVisible(false);
        testingButton.setBackground(new Color(204, 204, 204));
        homeButton.setBackground(new Color(51, 51, 51));
        searchButton.setBackground(new Color(51, 51, 51));
        predictiveButton.setBackground(new Color(51, 51, 51));
        helpButton.setBackground(new Color(51, 51, 51));
        helpButton.setForeground(new Color(204, 204, 204));
        homeButton.setForeground(new Color(204, 204, 204));
        searchButton.setForeground(new Color(204, 204, 204));
        predictiveButton.setForeground(new Color(204, 204, 204));
        testingButton.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_testingButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        helpPanel.setVisible(true);
        testingPanel.setVisible(false);
        predictPanel.setVisible(false);
        homePanel.setVisible(false);
        searchPanel.setVisible(false);
        helpButton.setBackground(new Color(204, 204, 204));
        homeButton.setBackground(new Color(51, 51, 51));
        searchButton.setBackground(new Color(51, 51, 51));
        predictiveButton.setBackground(new Color(51, 51, 51));
        testingButton.setBackground(new Color(51, 51, 51));
        helpButton.setForeground(new Color(51, 51, 51));
        homeButton.setForeground(new Color(204, 204, 204));
        searchButton.setForeground(new Color(204, 204, 204));
        predictiveButton.setForeground(new Color(204, 204, 204));
        testingButton.setForeground(new Color(204, 204, 204));
        
        homeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Help_Controller(helpInfo, 1);
            }
        });
        
        searchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Help_Controller(helpInfo, 2);
            }
        });
        
        predictiveButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Help_Controller(helpInfo, 3);
            }
        });
        
        testingButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Help_Controller(helpInfo, 4);
            }
        });
    }//GEN-LAST:event_helpButtonActionPerformed

    private void serverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverButtonActionPerformed
        new Server_Controller(conn, server, this);
    }//GEN-LAST:event_serverButtonActionPerformed

    private void homeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButton2ActionPerformed

    }//GEN-LAST:event_homeButton2ActionPerformed

    private void searchButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton2ActionPerformed

    }//GEN-LAST:event_searchButton2ActionPerformed

    private void predictiveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictiveButton2ActionPerformed

    }//GEN-LAST:event_predictiveButton2ActionPerformed

    private void testingButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingButton2ActionPerformed

    }//GEN-LAST:event_testingButton2ActionPerformed

    public final void noBorder(){
        toprise.setFocusPainted(false);
        topfall.setFocusPainted(false);
        mostsell.setFocusPainted(false);
        leastsell.setFocusPainted(false);
        homeButton.setFocusPainted(false);
        searchButton.setFocusPainted(false);
        predictiveButton.setFocusPainted(false);
        testingButton.setFocusPainted(false);
        helpButton.setFocusPainted(false);
        lookButton.setFocusPainted(false);
        serverButton.setFocusPainted(false);
        homeButton2.setFocusPainted(false);
        searchButton2.setFocusPainted(false);
        predictiveButton2.setFocusPainted(false);
        testingButton2.setFocusPainted(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusketeersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusketeersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusketeersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusketeersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JTextArea helpInfo;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JLabel helpText;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton homeButton2;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leastsell;
    private javax.swing.JButton lookButton;
    private javax.swing.JButton mostsell;
    private javax.swing.JPanel predictPanel;
    private javax.swing.JButton predictiveButton;
    private javax.swing.JButton predictiveButton2;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton2;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton serverButton;
    private javax.swing.JButton testingButton;
    private javax.swing.JButton testingButton2;
    private javax.swing.JPanel testingPanel;
    private javax.swing.JButton topfall;
    private javax.swing.JButton toprise;
    // End of variables declaration//GEN-END:variables
}