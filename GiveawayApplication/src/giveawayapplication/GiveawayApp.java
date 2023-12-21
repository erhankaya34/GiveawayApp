
package giveawayapplication;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author erhankaya
 */
public class GiveawayApp extends javax.swing.JFrame {
    
    private String filePath;
    private ArrayList<String> participants = new ArrayList<String>();
    
    //seçilen kişinin tekrar seçilmemesi adına kazananları set olarak tanımlıyorum
    private Set<String> winners = new TreeSet<String>();
    
    private DefaultListModel<String> winnerModel = new DefaultListModel<>();
    private DefaultListModel<String> backupModel = new DefaultListModel<>();

    
    private String selectWinner(ArrayList<String> participants) {
    while (true) {
        int randomIndex = (int) (Math.random() * participants.size());
        String winner = participants.get(randomIndex);

        // Kontrol: Kazananlar listesinde bu isim var mı?
        if (!winners.contains(winner)) {
            participants.remove(randomIndex);
            return winner;
        }
    }
   }
    private String selectBackupWinner(ArrayList<String> participants) {
    while (true) {
        int randomIndex = (int) (Math.random() * participants.size());
        String backupWinner = participants.get(randomIndex);

        // Kontrol: Kazananlar veya yedek kazananlar listesinde bu isim var mı?
        if (!winners.contains(backupWinner) && !backupModel.contains(backupWinner)) {
            participants.remove(randomIndex);
            return backupWinner;
        }
    }
}


   
    public void conductDraw() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
        String person;

        while ((person = reader.readLine()) != null) {
            participants.add(person);
        }

    } catch (IOException ex) {
        Logger.getLogger(GiveawayApp.class.getName()).log(Level.SEVERE, null, ex);
    }

    int mainWinnersCount = Integer.parseInt(txtWinnerNumber.getText());
    int backupWinnersCount = Integer.parseInt(txtBackupNumber.getText());

    if (participants.size() < mainWinnersCount + backupWinnersCount) {
        JOptionPane.showMessageDialog(this, "Not enough participants for the draw.");
        return;
    }

    
    winners.clear();
    winnerModel.clear();
    backupModel.clear();

    for (int i = 0; i < mainWinnersCount; i++) {
    String winner = selectWinner(participants);

    
    winners.add(winner);
    winnerModel.addElement(winner);
}
    listWinner.setModel(winnerModel);

    for (int i = 0; i < backupWinnersCount; i++) {
    String backupWinner = selectBackupWinner(participants);
    backupModel.addElement(backupWinner);
}
    listBackup.setModel(backupModel);
}
    
    public GiveawayApp() {
        initComponents();
        listWinner.setModel(winnerModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listWinner = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listBackup = new javax.swing.JList<>();
        lblWinnerList = new javax.swing.JLabel();
        lblBackupList = new javax.swing.JLabel();
        btnDraw = new javax.swing.JButton();
        lblMainWinners = new javax.swing.JLabel();
        txtWinnerNumber = new javax.swing.JTextField();
        lblbackupWinners = new javax.swing.JLabel();
        txtBackupNumber = new javax.swing.JTextField();
        txtFilePath = new javax.swing.JTextField();
        lblFilePath = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblMainText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        listWinner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listWinner);

        listBackup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(listBackup);

        lblWinnerList.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        lblWinnerList.setForeground(new java.awt.Color(255, 255, 255));
        lblWinnerList.setText("Winners");

        lblBackupList.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        lblBackupList.setForeground(new java.awt.Color(255, 255, 255));
        lblBackupList.setText("Backup");

        btnDraw.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        btnDraw.setText("Conduct The Draw");
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });

        lblMainWinners.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        lblMainWinners.setForeground(new java.awt.Color(255, 255, 255));
        lblMainWinners.setText("Number of Main Winners:");

        txtWinnerNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWinnerNumberActionPerformed(evt);
            }
        });

        lblbackupWinners.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        lblbackupWinners.setForeground(new java.awt.Color(255, 255, 255));
        lblbackupWinners.setText("Number of Backup Winners:");

        txtFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilePathActionPerformed(evt);
            }
        });

        lblFilePath.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        lblFilePath.setForeground(new java.awt.Color(255, 255, 255));
        lblFilePath.setText("File Path");

        btnBrowse.setFont(new java.awt.Font("YouYuan", 1, 14)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giveawayapplication/Images/bugzone_img.png"))); // NOI18N

        lblMainText.setFont(new java.awt.Font("OCR A Extended", 1, 22)); // NOI18N
        lblMainText.setForeground(new java.awt.Color(255, 255, 255));
        lblMainText.setText("BUG ZONE GAME DEVELOPMENT CLUB GIVEAWAY APP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFilePath)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblMainWinners)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtWinnerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblWinnerList)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblbackupWinners)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtBackupNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBackupList)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMainText)
                        .addGap(168, 168, 168))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblMainText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(lblFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMainWinners)
                            .addComponent(txtWinnerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDraw)
                            .addComponent(txtBackupNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblbackupWinners))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWinnerList)
                            .addComponent(lblBackupList)))
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int path = fileChooser.showOpenDialog(this);
        
        if(path == JFileChooser.APPROVE_OPTION)
        {    
            this.filePath = fileChooser.getSelectedFile().getPath();
            txtFilePath.setText(filePath);
        }
        
        
        
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtWinnerNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWinnerNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWinnerNumberActionPerformed

    private void txtFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilePathActionPerformed

    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        
        if (this.filePath == null || this.filePath.isEmpty()) 
        {
        JOptionPane.showMessageDialog(this, "Please choose a source file");
        return;
        }
        
        if (txtWinnerNumber.getText().isEmpty() || txtBackupNumber.getText().isEmpty()) 
        {
        JOptionPane.showMessageDialog(this, "Please enter a valid value.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        

    conductDraw();
        
    }//GEN-LAST:event_btnDrawActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiveawayApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDraw;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBackupList;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMainText;
    private javax.swing.JLabel lblMainWinners;
    private javax.swing.JLabel lblWinnerList;
    private javax.swing.JLabel lblbackupWinners;
    private javax.swing.JList<String> listBackup;
    private javax.swing.JList<String> listWinner;
    private javax.swing.JTextField txtBackupNumber;
    private javax.swing.JTextField txtFilePath;
    private javax.swing.JTextField txtWinnerNumber;
    // End of variables declaration//GEN-END:variables
}
