/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trandpl.dao.JobDAO;
import trandpl.dao.ResultDAO;
import trandpl.pojo.CurrentUser;
import trandpl.pojo.ParticipantJobPojo;

/**
 *
 * @author aadarsh jain
 */
public class PtViewAllAppliedJobsFrame extends javax.swing.JFrame {

    /**
     * Creates new form PtViewAllAppliedJobsFrame
     */
    private DefaultTableModel model;
    private List<ParticipantJobPojo> allAppliedJobsList;
    public PtViewAllAppliedJobsFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblName2.setText(CurrentUser.getName());
        model=(DefaultTableModel)tblAllJobs2.getModel();
        loadAppliedJobsDetails();
    }

     private void loadAppliedJobsDetails(){
        try{
            allAppliedJobsList=ResultDAO.getAllAppliedJobs(CurrentUser.getId());
            for(ParticipantJobPojo job:allAppliedJobsList){
                Vector<String> row=new Vector<>();
                row.add(job.getJobId());
                row.add(job.getJobTitle());
                row.add(job.getCompanyName());
                row.add(job.getTags());
                model.addRow(row);
            }
            if(allAppliedJobsList.isEmpty()){
                JOptionPane.showMessageDialog(null, "You Haven't Applied For Any Job yet","Applied Job Not Present",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "SQL Error!","DB Problem",JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAllJobs2 = new javax.swing.JTable();
        btnBack2 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        btnTakeQuiz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(243, 246, 254));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 200));

        jLabel8.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel8.setText("Welcome ,");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lblName2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jPanel4.add(lblName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 250, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/job.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 290, 220));

        tblAllJobs2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Id", "Job Title", "Company Name", "Skills Required"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAllJobs2);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 630, 240));

        btnBack2.setBackground(new java.awt.Color(173, 192, 234));
        btnBack2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBack2.setText("Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        btnLogout.setBackground(new java.awt.Color(173, 192, 234));
        btnLogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel4.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, -1, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 940, 10));

        jLabel10.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel10.setText("All Applied Job's -");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 140, -1));

        btnTakeQuiz.setBackground(new java.awt.Color(173, 192, 234));
        btnTakeQuiz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTakeQuiz.setText("Take Quiz");
        btnTakeQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeQuizActionPerformed(evt);
            }
        });
        jPanel4.add(btnTakeQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        new ParticipantsOptionsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTakeQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeQuizActionPerformed
        // TODO add your handling code here:
        int row=tblAllJobs2.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(null, "Please select row first!");
        }
       String jobId=tblAllJobs2.getValueAt(row, 0).toString().trim();
       String jobTitle=tblAllJobs2.getValueAt(row, 1).toString().trim();
       String companyName=tblAllJobs2.getValueAt(row, 2).toString().trim();
       PtTakeQuizFrame quizFrame=new PtTakeQuizFrame(jobId,jobTitle,companyName);
//        try{
//
//            boolean responce=ResultDAO.applyForJob(result);
//            if(responce){
//
//                JOptionPane.showMessageDialog(null, "Applied For Job Successfully\nNow You Can Apply For Test Via ViewAppliedJobs","Application Successful!",JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }else{
//                JOptionPane.showMessageDialog(null, "Could Not Applied For Job!","Application Unsuccessful!",JOptionPane.INFORMATION_MESSAGE);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "DB Error ","Error!",JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        }
    }//GEN-LAST:event_btnTakeQuizActionPerformed

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
            java.util.logging.Logger.getLogger(PtViewAllAppliedJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAppliedJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAppliedJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAppliedJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PtViewAllAppliedJobsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTakeQuiz;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JTable tblAllJobs2;
    // End of variables declaration//GEN-END:variables
}
