/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import trandpl.dao.ParticipantsDAO;
import trandpl.dao.QuestionDAO;
import trandpl.dao.ResultDAO;
import trandpl.pojo.CurrentUser;
import trandpl.pojo.QuestionPojo;
import trandpl.pojo.ResultsPojo;

/**
 *
 * @author aadarsh jain
 */


public class PtTakeQuizFrame extends javax.swing.JFrame {

    /**
     * Creates new form PtTakeQuizFrame
     */
    private String jobId;
    private String Pid;
    private String jobTitle;
    private String companyName;
    private int counter =0;
    private QuestionPojo currentQuestion;
    private List<QuestionPojo> questionList;
    private List<Integer> answerList;
    
    Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
    public PtTakeQuizFrame() {
        initComponents();
                this.setLocationRelativeTo(null);
                lblCounter.setText("01:00");
		second =0;
		minute =1;
		countdownTimer();
		timer.start();	
                
    }

    public void countdownTimer() {
		
	timer = new Timer(1000, new ActionListener() {
			
	@Override
	public void actionPerformed(ActionEvent e) {
				
 	    second--;
	    ddSecond = dFormat.format(second);
	    ddMinute = dFormat.format(minute);	
	    lblCounter.setText(ddMinute + ":" + ddSecond);
				
	    if(second==-1) {
	    second = 59;
            minute--;
	    ddSecond = dFormat.format(second);
	    ddMinute = dFormat.format(minute);	
	    lblCounter.setText(ddMinute + ":" + ddSecond);
	    }
	    if(minute==0 && second==0) {
            
	    timer.stop();
            int res=validateChooseOption();
            if(res==0){
            JOptionPane.showMessageDialog(null, "Please Select An Option","No Option Selected!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.add(counter, res);
        double per=getPercentage();
        ResultsPojo result=new ResultsPojo();
        result.setJobId(jobId);
        result.setpId(CurrentUser.getId());
        if(per<5.0){
            per=5.0;}
        result.setPercentage(per);
        result.setSelectedByHr("No");
        
         final String username="mrabhig2000@gmail.com";
        final String password="vhgeafzwgyqelzoq";
        //step 1
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new  MyAuthenticator(username,password);
        Session session=Session.getInstance(prop, myAuth);
        
        
        try{
            Pid=ParticipantsDAO.getParticipantUserId(CurrentUser.getId());
            boolean resp=ResultDAO.setResult(result);
            if(resp==true){
                JOptionPane.showMessageDialog(null, "You Got "+per+"% marks\nAnd Result Has Been Sent On Your Mail","Result!",JOptionPane.INFORMATION_MESSAGE);
                 new PtViewAllAppliedJobsFrame().setVisible(true);
                 dispose();
             Message message=new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(Pid);
            message.setRecipients(Message.RecipientType.TO, recipients);
            
            message.setSubject(companyName);
            message.setText("Dear student,\nYour result sucessfully submitted.\nYou Got "+per+"% marks in you wrritten test");
            Transport.send(message);
            System.out.println("Mail successfully send");
            }
          
        }
        catch(MessagingException ex) {
            ex.printStackTrace();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error In Take Test!!","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
        
				}
			}
		});
       
        
    }
    
    public PtTakeQuizFrame(String jobId,String jobTitle,String companyName) {
        this();
        this.jobId=jobId;
        this.jobTitle=jobTitle;
        this.companyName=companyName;
        lblTitle.setText("Paper For "+this.jobTitle);
        lblQno.setText(""+(counter+1));
        this.setVisible(true);
        loadQuestionPaper();
    }
    
    private void loadQuestionPaper(){
        try{
            questionList=QuestionDAO.getQuestionPaperByJob(jobId);
            answerList=new ArrayList<>(questionList.size());//Java bydefault ArrayList ka size 10 krti hai.
            for(int i=0;i<questionList.size();i++){//yha pr questionList isliye hai kyoki java ArrayList jabhi
                                                   //create krti hai jb ArrayList me element add ho.
                answerList.add(i,0);
            }
            showNextQuestionInFrame();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error In Quiz","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void showNextQuestionInFrame(){
        currentQuestion=questionList.get(counter);
        txtQuestion.setText(currentQuestion.getQuestion());
        jrbOption1.setText(currentQuestion.getOption1());
        jrbOption2.setText(currentQuestion.getOption2());
        jrbOption3.setText(currentQuestion.getOption3());
        jrbOption4.setText(currentQuestion.getOption4());
        int answer = answerList.get(counter);
        switch(answer){
            case 1:
                       jrbOption1.setSelected(true);
                       break;
            case 2:
                       jrbOption2.setSelected(true);
                       break;
            case 3:
                       jrbOption3.setSelected(true);
                       break;
            case 4:
                       jrbOption4.setSelected(true);
                       break;    
            default:
                       buttonGroup1.clearSelection();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        lblTitle = new javax.swing.JLabel();
        jrbOption2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jrbOption3 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jrbOption4 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        lblCounter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 200));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 910, 10));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("Que.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblQno.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jPanel1.add(lblQno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 30, 30));

        txtQuestion.setBackground(new java.awt.Color(173, 192, 234));
        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 800, 70));

        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel4.setText("Options -");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 100, 30));

        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel5.setText("Option 1");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 60, -1));

        jrbOption1.setBackground(new java.awt.Color(173, 192, 234));
        buttonGroup1.add(jrbOption1);
        jPanel1.add(jrbOption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 300, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 40));

        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("Option 2");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 70, -1));

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel9.setText("Option 3");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 60, -1));

        jLabel11.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel11.setText("Option 4");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 60, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 910, 10));

        btnPrevious.setBackground(new java.awt.Color(173, 192, 234));
        btnPrevious.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        btnNext.setBackground(new java.awt.Color(173, 192, 234));
        btnNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, -1, -1));

        btnDiscard.setBackground(new java.awt.Color(173, 192, 234));
        btnDiscard.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDiscard.setText("Discard Paper");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });
        jPanel1.add(btnDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, -1, -1));

        btnSubmit.setBackground(new java.awt.Color(173, 192, 234));
        btnSubmit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 910, 10));

        lblTitle.setBackground(new java.awt.Color(243, 246, 254));
        lblTitle.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblTitle.setText("jLabel3");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 204, 300, 30));

        jrbOption2.setBackground(new java.awt.Color(173, 192, 234));
        buttonGroup1.add(jrbOption2);
        jPanel1.add(jrbOption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 300, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, 40));

        jrbOption3.setBackground(new java.awt.Color(173, 192, 234));
        buttonGroup1.add(jrbOption3);
        jPanel1.add(jrbOption3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 300, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, 40));

        jrbOption4.setBackground(new java.awt.Color(173, 192, 234));
        buttonGroup1.add(jrbOption4);
        jPanel1.add(jrbOption4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 300, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, 40));

        lblCounter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCounter.setForeground(new java.awt.Color(255, 51, 51));
        lblCounter.setText("jLabel3");
        jPanel1.add(lblCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        int res=validateChooseOption();
        if(res==0){
            JOptionPane.showMessageDialog(null, "Please Select An Option","No Option Selected!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.add(counter, res);
        double per=getPercentage();
        ResultsPojo result=new ResultsPojo();
        result.setJobId(jobId);
        result.setpId(CurrentUser.getId());
        if(per<5.0){
            per=5.0;}
        result.setPercentage(per);
        result.setSelectedByHr("No");
        
        try{
            Pid=ParticipantsDAO.getParticipantUserId(CurrentUser.getId());
            boolean resp=ResultDAO.setResult(result);
            if(resp==true){
                JOptionPane.showMessageDialog(null, "You Got "+per+"% marks\nAnd Result Has Been Sent On Your Mail","Result!",JOptionPane.INFORMATION_MESSAGE);
            new PtViewAllAppliedJobsFrame().setVisible(true);
            this.dispose();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB Error In Take Test!!","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        final String username="mrabhig2000@gmail.com";
        final String password="vhgeafzwgyqelzoq";
        //step 1
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new  MyAuthenticator(username,password);
        Session session=Session.getInstance(prop, myAuth);
        
        try{
            Message message=new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(Pid);
            message.setRecipients(Message.RecipientType.TO, recipients);
             message.setSubject(companyName);
            message.setText("Dear student,\nYour result sucessfully submitted.\nYou Got "+per+"% marks in you wrritten test");
            Transport.send(message);
            System.out.println("Mail successfully send");
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        // TODO add your handling code here:
        new PtViewAllAvailableJobsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDiscardActionPerformed

    private int validateChooseOption(){
        if(jrbOption1.isSelected())
            return 1;
        else if(jrbOption2.isSelected())
            return 2;
        else if(jrbOption3.isSelected())
            return 3;
        else if(jrbOption4.isSelected())
            return 4;
        else
            return 0;
    }
    
    private double getPercentage(){
        int marksObtained=0;
        for(int i=0;i<questionList.size();i++){
            QuestionPojo question=questionList.get(i);
            if(question.getCorrectOption()==answerList.get(i)){
                ++marksObtained;
            }
        }
        double per=((double)marksObtained/questionList.size())*100;
        return per;
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int res=validateChooseOption();
        if(res==0){
            JOptionPane.showMessageDialog(null, "Please Select An Option","No Option Selected!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.add(counter, res);
        ++counter;
        if(counter==questionList.size()){
            counter=0;
        }
        showNextQuestionInFrame();
        lblQno.setText(""+(counter+1));
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        int res=validateChooseOption();
        if(res==0){
            JOptionPane.showMessageDialog(null, "Please Select An Option","No Option Selected!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.add(counter, res);
        --counter;
        if(counter==-1){
            counter=questionList.size()-1;
        }
        showNextQuestionInFrame();
        lblQno.setText(""+(counter+1));
    }//GEN-LAST:event_btnPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PtTakeQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblCounter;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
