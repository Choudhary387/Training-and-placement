/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trandpl.dao.JobDAO;
import trandpl.dao.QuestionDAO;
import trandpl.pojo.QuestionPojo;

/**
 *
 * @author aadarsh jain
 */
public class HrSetQuizFrame extends javax.swing.JFrame {

    /**
     * Creates new form HrSetQuizFrame
     */
    private int counter=0;//iski jarurat hume question no. set krne me to lagegi sathi hi arraylist me lagegi kyoki 
                          //hmne jo previous button diya hai usme question ka index voh hi rahe change na ho iske liye
                          //hum arraylist ke set method ko call krenge jo first index lega or second pojo ka object lega.
    private List<QuestionPojo> questionList=new ArrayList<>();
    private String jobId;
    public HrSetQuizFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblQno.setText(String.valueOf(counter+1));
    }

    public HrSetQuizFrame(String jobId) {
        this();
        this.jobId=jobId;
    }
    
    private boolean validateInput(){
        if(txtQuestion.getText().trim().isEmpty() || jcCorrectOption.getSelectedIndex()==0 || txtOption1.getText().trim().isEmpty() ||
                txtOption2.getText().trim().isEmpty() || txtOption3.getText().trim().isEmpty() || txtOption4.getText().trim().isEmpty())
            return false;
        return true;
    }
    
    public void clearText(){
        txtQuestion.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        jcCorrectOption.setSelectedIndex(0);
        txtQuestion.requestFocus();
    }
    
    private QuestionPojo setQuestion(){
        QuestionPojo question = new QuestionPojo();
        
        question.setJobId(jobId);
        question.setQno(counter + 1);
        question.setQuestion(txtQuestion.getText().trim());
        question.setOption1(txtOption1.getText().trim());
        question.setOption2(txtOption2.getText().trim());
        question.setOption3(txtOption3.getText().trim());
        question.setOption4(txtOption4.getText().trim());
        question.setCorrectOption(jcCorrectOption.getSelectedIndex());
        
        return question;
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOption2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOption3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtOption4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jcCorrectOption = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 200));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 910, 10));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("Que.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 30));

        lblQno.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jPanel1.add(lblQno, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 220, 30, 30));

        txtQuestion.setBackground(new java.awt.Color(173, 192, 234));
        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 220, 800, 70));

        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel4.setText("Options -");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, 30));

        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel5.setText("Option 1");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 60, -1));

        txtOption1.setBackground(new java.awt.Color(173, 192, 234));
        txtOption1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txtOption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 320, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 40));

        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("Option 2");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 70, -1));

        txtOption2.setBackground(new java.awt.Color(173, 192, 234));
        txtOption2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txtOption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 320, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, 40));

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel9.setText("Option 3");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 60, -1));

        txtOption3.setBackground(new java.awt.Color(173, 192, 234));
        txtOption3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txtOption3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 320, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, 40));

        jLabel11.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel11.setText("Option 4");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 60, -1));

        txtOption4.setBackground(new java.awt.Color(173, 192, 234));
        txtOption4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txtOption4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 320, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 910, 10));

        jLabel13.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel13.setText("Correct Option -");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 150, 40));

        jcCorrectOption.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        jcCorrectOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Correct Option", "Option 1", "Option 2", "Option 3", "Option 4" }));
        jPanel1.add(jcCorrectOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 250, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 910, 10));

        btnPrevious.setBackground(new java.awt.Color(173, 192, 234));
        btnPrevious.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        btnNext.setBackground(new java.awt.Color(173, 192, 234));
        btnNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        btnDiscard.setBackground(new java.awt.Color(173, 192, 234));
        btnDiscard.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDiscard.setText("Discard Paper");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });
        jPanel1.add(btnDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, -1, -1));

        btnSubmit.setBackground(new java.awt.Color(173, 192, 234));
        btnSubmit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 500, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void getQuestionFromList(){
        QuestionPojo question;
        question=questionList.get(counter);
        txtQuestion.setText(question.getQuestion());
        txtOption1.setText(question.getOption1());
        txtOption2.setText(question.getOption2());
        txtOption3.setText(question.getOption3());
        txtOption4.setText(question.getOption4());
        jcCorrectOption.setSelectedIndex(question.getCorrectOption());
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(validateInput()){
            QuestionPojo question = setQuestion();
            if(counter==questionList.size()){
                questionList.add(question);
                clearText();
                ++counter;
            }else{
                questionList.set(counter, question);
                ++counter;
                if(counter==questionList.size()){
                clearText();
                }else{
                    getQuestionFromList();
                }
            }
            lblQno.setText(String.valueOf(counter+1));
        }else{
            JOptionPane.showMessageDialog(null, "Please Fill All The Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if(counter==0){
            return;
        }
        
        if(counter==questionList.size()){
            
            if(validateInput()){
                int result=JOptionPane.showConfirmDialog(null, "You have unsaved question.Do you want to save it ?", "Confirm ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result==JOptionPane.YES_OPTION){
                    QuestionPojo question = setQuestion();
                    questionList.add(question);
                    clearText();
                }
            }
            --counter;
            getQuestionFromList();
        }
        else{
             if(validateInput()){
                 QuestionPojo question = setQuestion();
                 questionList.set(counter,question);
                  --counter;
                 getQuestionFromList();
             }else{
            JOptionPane.showMessageDialog(null, "Please Fill All The Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
        }
        }
         lblQno.setText(String.valueOf(counter+1));
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if(validateInput()){
            QuestionPojo que=setQuestion();
            if(counter==questionList.size()){
                questionList.add(que);
            }else{
                questionList.set(counter,que);
            }
            
            try{
            boolean result=QuestionDAO.setPaper(questionList);
            if(result){
                JOptionPane.showMessageDialog(null, "Question Paper Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                JobDAO.setJobStatus(jobId);
                new HrQuizOptionFrame().setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Could Not Add The Paper", "Failure!!", JOptionPane.WARNING_MESSAGE);
            }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "DB Error", "Error In DB Communication", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please Fill All The Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        // TODO add your handling code here:
        new HrChooseJobForSettingQuizFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDiscardActionPerformed

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
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrSetQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcCorrectOption;
    private javax.swing.JLabel lblQno;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
