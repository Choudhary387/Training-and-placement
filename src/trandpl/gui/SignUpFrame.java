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
import trandpl.dao.ParticipantsDAO;
import trandpl.pojo.ParticipantsPojo;

/**
 *
 * @author aadarsh jain
 */
public class SignUpFrame extends javax.swing.JFrame {

    /**
     * Creates new form SignUpFrame
     */
    private File file;
    private String pwd,cnfpwd;
    public SignUpFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadId();
    }

    private boolean validateInputs(){
       char chpwd[]=txtPwd.getPassword();
       char chcnfpwd[]=txtCnfPwd.getPassword();
       if(txtName.getText().trim().isEmpty() || txtMail.getText().trim().isEmpty() || txtPhone.getText().trim().isEmpty() 
          || chpwd.length==0 || chcnfpwd.length==0||txtSkill1.getText().trim().isEmpty() || txtSkill2.getText().trim().isEmpty() 
          || txtSkill3.getText().trim().isEmpty() || txtSkill4.getText().trim().isEmpty() || txtFilePath.getText().trim().isEmpty()
          || txtQualification.getText().trim().isEmpty() ){
           return false;
       }
       return true;
    }
    
    private void clearAll(){
        txtName.setText("");
        txtMail.setText("");
        txtPhone.setText("");
        txtFilePath.setText("");
        txtSkill1.setText("");
        txtSkill2.setText("");
        txtSkill3.setText("");
        txtSkill4.setText("");
        txtQualification.setText("");
        txtPwd.setText("");
        txtCnfPwd.setText("");
    }
    
    private boolean matchPasswords(){
        pwd=String.valueOf(txtPwd.getPassword());    
        cnfpwd=String.valueOf(txtCnfPwd.getPassword());   
        return pwd.equals(cnfpwd);
     }
    
    private void loadId(){
        try{
            int pId=ParticipantsDAO.getNewParticipantId();
            lblPid.setText("P-"+pId);
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "DB Error ","Error in generating HrID",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPid = new javax.swing.JLabel();
        txtQualification = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBrowseFile = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtFilePath = new javax.swing.JTextField();
        txtSkill1 = new javax.swing.JTextField();
        txtSkill2 = new javax.swing.JTextField();
        txtSkill3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSkill4 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnLoginPage = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        txtCnfPwd = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(243, 246, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 170));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel2.setText("Participants id :-");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, -1));

        lblPid.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jPanel2.add(lblPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 71, 20));

        txtQualification.setBackground(new java.awt.Color(173, 192, 234));
        txtQualification.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtQualification.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 760, 30));

        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel4.setText("Email :-");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 110, -1));

        txtPhone.setBackground(new java.awt.Color(173, 192, 234));
        txtPhone.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtPhone.setBorder(null);
        jPanel2.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 300, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        txtName.setBackground(new java.awt.Color(173, 192, 234));
        txtName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtName.setBorder(null);
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txtMail.setBackground(new java.awt.Color(173, 192, 234));
        txtMail.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtMail.setBorder(null);
        jPanel2.add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 300, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Name :-");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 538, 950, -1));

        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel5.setText("Mobile no :-");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        jLabel6.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel6.setText("Upload Resume");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 110, -1));

        btnBrowseFile.setBackground(new java.awt.Color(173, 192, 234));
        btnBrowseFile.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBrowseFile.setText("Browse File");
        btnBrowseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseFileActionPerformed(evt);
            }
        });
        jPanel2.add(btnBrowseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 100, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 400, 10));

        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("Skills -");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, -1));

        txtFilePath.setBackground(new java.awt.Color(173, 192, 234));
        txtFilePath.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtFilePath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 230, 30));

        txtSkill1.setBackground(new java.awt.Color(173, 192, 234));
        txtSkill1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtSkill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtSkill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 160, 30));

        txtSkill2.setBackground(new java.awt.Color(173, 192, 234));
        txtSkill2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtSkill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtSkill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 160, 30));

        txtSkill3.setBackground(new java.awt.Color(173, 192, 234));
        txtSkill3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtSkill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtSkill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 160, 30));

        jLabel8.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel8.setText("Qualification :-");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 170, -1));

        txtSkill4.setBackground(new java.awt.Color(173, 192, 234));
        txtSkill4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtSkill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtSkill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 160, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 950, 10));

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel9.setText("Password :-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 80, -1));

        jLabel10.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel10.setText("Confirm Password :-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 130, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 468, 950, -1));

        btnLoginPage.setBackground(new java.awt.Color(173, 192, 234));
        btnLoginPage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLoginPage.setText("Login Page");
        btnLoginPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPageActionPerformed(evt);
            }
        });
        jPanel2.add(btnLoginPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, -1));

        btnCreateAccount.setBackground(new java.awt.Color(173, 192, 234));
        btnCreateAccount.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCreateAccount.setText("Create Account");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        jPanel2.add(btnCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, -1, -1));

        txtPwd.setBackground(new java.awt.Color(173, 192, 234));
        txtPwd.setBorder(null);
        jPanel2.add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 310, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 340, 40));

        txtCnfPwd.setBackground(new java.awt.Color(173, 192, 234));
        txtCnfPwd.setBorder(null);
        jPanel2.add(txtCnfPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 310, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Select Your Resume");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result=fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            file=fileChooser.getSelectedFile();
            txtFilePath.setText(file.getName());
        }
        
        
    }//GEN-LAST:event_btnBrowseFileActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        // TODO add your handling code here:
        if(validateInputs()==false){
            JOptionPane.showMessageDialog(null, "Please input all the fields ","Incomplete Data!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(matchPasswords()==false){
            JOptionPane.showMessageDialog(null, "Password do not match ","Mismatched Passwords!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            ParticipantsPojo pt=new ParticipantsPojo();
            pt.setId(lblPid.getText().trim());
            pt.setUserId(txtMail.getText().trim());
            pt.setName(txtName.getText().trim());
            pt.setPhone(txtPhone.getText().trim());
            pt.setResume(file);
            pt.setSkills(txtSkill1.getText().trim()+","+txtSkill2.getText().trim()+","+txtSkill3.getText().trim()+","+txtSkill4.getText().trim());
            pt.setQualifications(txtQualification.getText().trim());
            pt.setPassword(pwd);
            
            pt.setType("Pt");
            int result=ParticipantsDAO.addNewParicipant(pt);
            if(result==1){
                JOptionPane.showMessageDialog(null, "Participant Added Successfully!","Success!",JOptionPane.INFORMATION_MESSAGE);
                clearAll();
                loadId();
                return;
            }else if(result==-1){
                JOptionPane.showMessageDialog(null, "Email-Id Alredy Taken!","Registration Failed!",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cannot Add The Record!","Registration Failed!",JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "DB Error ","DB Problem!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }catch(FileNotFoundException ex){
             JOptionPane.showMessageDialog(null, "File Error ","File Problem!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnLoginPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPageActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginPageActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseFile;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnLoginPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblPid;
    private javax.swing.JPasswordField txtCnfPwd;
    private javax.swing.JTextField txtFilePath;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSkill1;
    private javax.swing.JTextField txtSkill2;
    private javax.swing.JTextField txtSkill3;
    private javax.swing.JTextField txtSkill4;
    // End of variables declaration//GEN-END:variables
}
