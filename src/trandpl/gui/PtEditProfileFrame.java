/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import trandpl.dao.ParticipantsDAO;
import trandpl.dao.UserDAO;
import trandpl.pojo.CurrentUser;
import trandpl.pojo.ParticipantsPojo;

/**
 *
 * @author aadarsh jain
 */
public class PtEditProfileFrame extends javax.swing.JFrame {

    /**
     * Creates new form PtEditProfileFrame
     */
    private File file;
    private String oldpwd,npwd,cnfpwd;
    
    public PtEditProfileFrame() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        pwdPanel.setVisible(false);
        resumePanel.setVisible(false);
        loadData();
    }

    private void loadData(){
        try{
            ParticipantsPojo pt=ParticipantsDAO.getParticipantById(CurrentUser.getId());
            txtName.setText(pt.getName());
            txtMail2.setText(pt.getUserId());
            txtPhone.setText(pt.getPhone());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error In Edit Profile","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private boolean validateInputs(){
        char []arroldpwd=txtPassword.getPassword();
        char []arrnpwd=txtNewPassword.getPassword();
        char []arrcnfrmpwd=txtCnfrmNewPassword.getPassword();
        
        if(arroldpwd.length==0 ||arrnpwd.length==0 || arrcnfrmpwd.length==0 ){
            return false;
        }
        oldpwd=String.valueOf(arroldpwd);
        npwd=String.valueOf(arrnpwd);
        cnfpwd=String.valueOf(arrcnfrmpwd);
        return true;
    }
    
    private boolean matchPassword(){
        return npwd.equals(cnfpwd);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMail2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnDiscard = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        chkPassword = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        chkResume = new javax.swing.JCheckBox();
        pwdPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        txtCnfrmNewPassword = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        resumePanel = new javax.swing.JPanel();
        txtFilePath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();

        txtMail.setBackground(new java.awt.Color(173, 192, 234));
        txtMail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtMail.setBorder(null);
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 200));

        txtName.setBackground(new java.awt.Color(173, 192, 234));
        txtName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtName.setBorder(null);
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 300, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel3.setText("Name :-");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, -1));

        txtPhone.setBackground(new java.awt.Color(173, 192, 234));
        txtPhone.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtPhone.setBorder(null);
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 300, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txtMail2.setBackground(new java.awt.Color(173, 192, 234));
        txtMail2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtMail2.setBorder(null);
        jPanel1.add(txtMail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 300, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel4.setText("Phone no:-");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 92, -1));

        jLabel5.setText("Mail Adderes :-");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 910, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 910, 10));

        btnDiscard.setText("Discard Changes");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });
        jPanel1.add(btnDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, -1, -1));

        btnSave.setText("Save Changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, 10));

        jLabel6.setText("Want To Change Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 170, 40));

        chkPassword.setBackground(new java.awt.Color(243, 246, 254));
        chkPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(chkPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, -1, 40));

        jLabel7.setText("Want To Change Resume");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 160, 20));

        chkResume.setBackground(new java.awt.Color(243, 246, 254));
        chkResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkResumeActionPerformed(evt);
            }
        });
        jPanel1.add(chkResume, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        pwdPanel.setBackground(new java.awt.Color(243, 246, 254));
        pwdPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Current Passwoord");
        pwdPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, -1, -1));

        jLabel9.setText("New Password");
        pwdPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 92, 20));

        jLabel10.setText("Confirm Password");
        pwdPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, 92, 20));

        txtPassword.setBackground(new java.awt.Color(173, 192, 234));
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pwdPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 300, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        pwdPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        txtNewPassword.setBackground(new java.awt.Color(173, 192, 234));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pwdPanel.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 310, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        pwdPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        txtCnfrmNewPassword.setBackground(new java.awt.Color(173, 192, 234));
        txtCnfrmNewPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pwdPanel.add(txtCnfrmNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 310, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        pwdPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jPanel1.add(pwdPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 520, 190));

        resumePanel.setBackground(new java.awt.Color(243, 246, 254));
        resumePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "* Upload resume in within 1000kb", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 51, 51))); // NOI18N
        resumePanel.setForeground(new java.awt.Color(243, 246, 254));
        resumePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        resumePanel.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 27, 650, 28));

        btnBrowse.setBackground(new java.awt.Color(173, 192, 234));
        btnBrowse.setText("Browse File");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        resumePanel.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 102, -1));

        jPanel1.add(resumePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 890, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void chkPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPasswordActionPerformed
        // TODO add your handling code here:
        if(chkPassword.isSelected()){
            pwdPanel.setVisible(true);
        }else{
             pwdPanel.setVisible(false);
        }
    }//GEN-LAST:event_chkPasswordActionPerformed

    private void chkResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkResumeActionPerformed
        // TODO add your handling code here:
        if(chkResume.isSelected()){
            resumePanel.setVisible(true);
        }else{
             resumePanel.setVisible(false);
        }
    }//GEN-LAST:event_chkResumeActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Select Your Resume");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result=fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            file=fileChooser.getSelectedFile();
            txtFilePath.setText(file.getName());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        // TODO add your handling code here:
        new ParticipantsOptionsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        boolean pwdChanged=false,resumeUpdated=false;
        if(chkPassword.isSelected()){
            if(validateInputs()==false){
                JOptionPane.showMessageDialog(null, "Please Fill All The Fields","Empty Field!",JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(matchPassword()==false){
                JOptionPane.showMessageDialog(null, "Password And Confirm Password Do Not Match","Password Mismatched!",JOptionPane.WARNING_MESSAGE);
                return;
            }
            try{
                boolean resp=UserDAO.checkOldPassword(CurrentUser.getId(), oldpwd);
                if(resp==true){
                    UserDAO.updateParticipantPassword(CurrentUser.getId(), npwd);
                    pwdChanged=true;
                }else{
                    JOptionPane.showMessageDialog(null, "Your Old Password Is Wrong","Password Mismatched!",JOptionPane.WARNING_MESSAGE);
                 
                }
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error In Edit Profile","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        }
        
        if(chkResume.isSelected()){
            if(txtFilePath.getText().trim()!=""){
                try{
                    ParticipantsDAO.updateResume(CurrentUser.getId(), file);
                    resumeUpdated=true;
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "DB Error In Edit Profile","Error!",JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "File Error In Edit Profile","Error!",JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
        }
        }
        if(pwdChanged && resumeUpdated){
            JOptionPane.showMessageDialog(null, "Password & Resume Updated Successfully","Success",JOptionPane.INFORMATION_MESSAGE);     
        }else if(pwdChanged){
            JOptionPane.showMessageDialog(null, "Password  Updated Successfully","Success",JOptionPane.INFORMATION_MESSAGE);     
        }else if(resumeUpdated){
            JOptionPane.showMessageDialog(null, "Resume Updated Successfully","Success",JOptionPane.INFORMATION_MESSAGE);     
        }else{
            JOptionPane.showMessageDialog(null, "No Changes Done!!","Message!",JOptionPane.INFORMATION_MESSAGE);     
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(PtEditProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PtEditProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PtEditProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PtEditProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PtEditProfileFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkPassword;
    private javax.swing.JCheckBox chkResume;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel pwdPanel;
    private javax.swing.JPanel resumePanel;
    private javax.swing.JPasswordField txtCnfrmNewPassword;
    private javax.swing.JTextField txtFilePath;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMail2;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
