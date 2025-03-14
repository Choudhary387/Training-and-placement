/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.gui;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import trandpl.dao.UserDAO;
import trandpl.pojo.CurrentUser;
import trandpl.pojo.HrPojo;
import trandpl.pojo.UserPojo;

/**
 *
 * @author aadarsh jain
 */
public class AdminModifyHrFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminModifyHrFrame
     */
    private Map<String,HrPojo> allHr;
    private String Password;
    public AdminModifyHrFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblName.setText(CurrentUser.getName());
        loadHrDetails();
    }
   
     private boolean validateInputs(){
         char []pwd=txtPassword.getPassword();
         char []repwd=txtRePassword.getPassword();
         if(pwd.length < 4 || repwd.length < 4){
             JOptionPane.showMessageDialog(null, "Password must be alleast 4 characters long");
         }
         Password=String.valueOf(pwd);
         String rePassword=String.valueOf(repwd);
         if(Password.equals(rePassword)==false){
             JOptionPane.showMessageDialog(null, "Password does not match");
             return false;
         }
         return true;
     }
     
     private void clearText(){
         txtPassword.setText("");
         txtRePassword.setText("");
         jcAllUserId.setSelectedIndex(0);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcAllUserId = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtHrId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblHrName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtRePassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnModifyChangesOfHr = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\aadarsh jain\\Downloads\\java\\Java TnP Project material\\images\\World-Map.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -3, 981, 210));

        jLabel2.setBackground(new java.awt.Color(243, 246, 254));
        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        jLabel2.setText("Welcome ,");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, -1, -1));

        lblName.setBackground(new java.awt.Color(243, 246, 254));
        lblName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 218, 260, 32));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\aadarsh jain\\Downloads\\java\\Java TnP Project material\\images\\modify-emp.png")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 167, 195));

        jLabel3.setBackground(new java.awt.Color(243, 246, 254));
        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel3.setText("User id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 88, -1));

        jcAllUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAllUserIdActionPerformed(evt);
            }
        });
        jPanel1.add(jcAllUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 270, 40));

        jLabel4.setBackground(new java.awt.Color(243, 246, 254));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel4.setText("Hr id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 127, -1));

        txtHrId.setBackground(new java.awt.Color(173, 192, 234));
        txtHrId.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        txtHrId.setBorder(null);
        jPanel1.add(txtHrId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 300, 20));

        jLabel7.setBackground(new java.awt.Color(243, 246, 254));
        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel7.setText("Hr Name -");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 80, -1));

        lblHrName.setBackground(new java.awt.Color(243, 246, 254));
        lblHrName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jPanel1.add(lblHrName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 210, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 372, 320, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 476, 981, 10));

        jLabel9.setBackground(new java.awt.Color(243, 246, 254));
        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel9.setText("New Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 170, -1));

        txtRePassword.setBackground(new java.awt.Color(173, 192, 234));
        txtRePassword.setBorder(null);
        jPanel1.add(txtRePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 310, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        txtPassword.setBackground(new java.awt.Color(173, 192, 234));
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 310, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 340, -1));

        jLabel13.setBackground(new java.awt.Color(243, 246, 254));
        jLabel13.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel13.setText("Confirm Password");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 150, -1));

        btnBack.setBackground(new java.awt.Color(173, 192, 254));
        btnBack.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        btnModifyChangesOfHr.setBackground(new java.awt.Color(173, 192, 254));
        btnModifyChangesOfHr.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnModifyChangesOfHr.setText("Modify Changes Of Hr");
        btnModifyChangesOfHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyChangesOfHrActionPerformed(evt);
            }
        });
        jPanel1.add(btnModifyChangesOfHr, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 230, -1));

        btnLogout.setBackground(new java.awt.Color(173, 192, 254));
        btnLogout.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcAllUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAllUserIdActionPerformed
        // TODO add your handling code here:
        String userId = (String)jcAllUserId.getSelectedItem();
        HrPojo hr=allHr.get(userId);
        txtHrId.setText(hr.getHrId());
        lblHrName.setText(hr.getHrName());
    }//GEN-LAST:event_jcAllUserIdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new AdminHrModuleFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnModifyChangesOfHrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyChangesOfHrActionPerformed
        // TODO add your handling code here:
        if(!validateInputs()){
            return;
        }
        try{
            boolean result = UserDAO.updatePwd(jcAllUserId.getSelectedItem().toString(), Password);
            if(result){
                JOptionPane.showMessageDialog(null, "Password Changed Successfully","Done!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Sorry could not change the Password","Unsuccessfull!",JOptionPane.ERROR_MESSAGE);
            }
            clearText();
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "DB Error ","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnModifyChangesOfHrActionPerformed

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
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminModifyHrFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnModifyChangesOfHr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcAllUserId;
    private javax.swing.JLabel lblHrName;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtHrId;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRePassword;
    // End of variables declaration//GEN-END:variables

    private void loadHrDetails() {
        try{
            allHr=UserDAO.getAllHrList();
            Set<String> keys=allHr.keySet();
            for(String userId :keys){
                jcAllUserId.addItem(userId);
            }
        } catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "DB Error ","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
