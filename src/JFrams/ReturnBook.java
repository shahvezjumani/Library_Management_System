/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrams;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ReturnBook extends javax.swing.JFrame {

    Color mouseExitColor = new Color(153,153,153);
    Color mouseEnterColor = new Color(0,0,0);
    public ReturnBook() {
        initComponents();
    }

    public boolean getBookIssueDetails(){
        boolean is_present = false;
        String book_id = studentidTF3.getText();
        String student_id = studentidTF4.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from issuebook where book_id = ? and student_id = ? and status = ? ");
            pstm.setString(1, book_id);
            pstm.setString(2, student_id);
            pstm.setString(3, "pending");            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                is_present = true;
                String id = rs.getString(1);
                issueidL.setText(id);
                booknameL.setText(rs.getString(3));
                stunameL.setText(rs.getString(5));                
                java.util.Date issue_date = rs.getDate(6);
                issuedateL.setText(issue_date.toString());
                
                java.util.Date due_date = rs.getDate(7);
                duedateL.setText(due_date.toString());                
            }
            else{
                is_present = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return is_present;
    }
    public void updateCount(){
        String book_id = studentidTF3.getText();
        String student_id = studentidTF4.getText();
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("update book set quantity = quantity+1 where id = ?");
            pstm.setString(1, book_id);
            int rowcount = pstm.executeUpdate();
            
            if(rowcount > 0){
                JOptionPane.showMessageDialog(this, "Book Returned Successfully");
                pstm = con.prepareStatement("update issuebook set status = ? where book_id = ? and student_id = ? and status = ?");
                pstm.setString(2, book_id);
                pstm.setString(3, student_id);
                pstm.setString(1, "returned");
                pstm.setString(4, "pending");
                pstm.executeUpdate(); 
            }
            else{
                JOptionPane.showMessageDialog(this, "Book not Returned Successfully");                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        studentidTF4 = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        studentidTF3 = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        findbookbutton = new rojerusan.RSMaterialButtonRectangle();
        returnbookbutton1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        stunameL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        issueidL = new javax.swing.JLabel();
        booknameL = new javax.swing.JLabel();
        issuedateL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        duedateL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Return Book");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 360, 50));

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 80, -1));

        studentidTF4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        studentidTF4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        studentidTF4.setPhColor(new java.awt.Color(51, 51, 51));
        studentidTF4.setPlaceholder("Enter Student Id ...");
        studentidTF4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentidTF4FocusLost(evt);
            }
        });
        studentidTF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidTF4ActionPerformed(evt);
            }
        });
        jPanel6.add(studentidTF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 150, -1));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel13.setText("Book Id :");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        studentidTF3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        studentidTF3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        studentidTF3.setPhColor(new java.awt.Color(51, 51, 51));
        studentidTF3.setPlaceholder("Enter Book Id ...");
        studentidTF3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentidTF3FocusLost(evt);
            }
        });
        studentidTF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidTF3ActionPerformed(evt);
            }
        });
        jPanel6.add(studentidTF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 150, -1));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel15.setText("Student Id :");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        findbookbutton.setBackground(new java.awt.Color(255, 51, 0));
        findbookbutton.setText("FIND BOOK");
        findbookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findbookbuttonActionPerformed(evt);
            }
        });
        jPanel6.add(findbookbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        returnbookbutton1.setBackground(new java.awt.Color(255, 51, 0));
        returnbookbutton1.setText("RETURN BOOK");
        returnbookbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookbutton1ActionPerformed(evt);
            }
        });
        jPanel6.add(returnbookbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 350, 720));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 44)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 390, 110));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 350, 10));

        stunameL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        stunameL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(stunameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 210, 30));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel5.setText("Issue id : ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, 30));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel6.setText("Book name : ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, 30));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel7.setText("Student name : ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 140, 30));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel8.setText("Issue date :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 140, 30));

        issueidL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        issueidL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(issueidL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 210, 30));

        booknameL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        booknameL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(booknameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 210, 30));

        issuedateL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        issuedateL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(issuedateL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 210, 30));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel9.setText("Due date :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 140, 30));

        duedateL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        duedateL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(duedateL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 210, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 370, 750));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, 150, 1000, 500));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 110, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 720));

        setSize(new java.awt.Dimension(1355, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void studentidTF4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentidTF4FocusLost
       
    }//GEN-LAST:event_studentidTF4FocusLost

    private void studentidTF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidTF4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidTF4ActionPerformed

    private void studentidTF3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentidTF3FocusLost
      
    }//GEN-LAST:event_studentidTF3FocusLost

    private void studentidTF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidTF3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidTF3ActionPerformed

    private void findbookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findbookbuttonActionPerformed
        if(getBookIssueDetails() == true){
           JOptionPane.showMessageDialog(this, "Record Found Successfully");
        }
        else{
            JOptionPane.showMessageDialog(this, "No record Found");
        }
    }//GEN-LAST:event_findbookbuttonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jPanel4.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel1MouseExited

    private void returnbookbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookbutton1ActionPerformed
        if(getBookIssueDetails() == true){
            updateCount();
        }
    }//GEN-LAST:event_returnbookbutton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel booknameL;
    private javax.swing.JLabel duedateL;
    private rojerusan.RSMaterialButtonRectangle findbookbutton;
    private javax.swing.JLabel issuedateL;
    private javax.swing.JLabel issueidL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private rojerusan.RSMaterialButtonRectangle returnbookbutton1;
    private app.bolivia.swing.JCTextField studentidTF3;
    private app.bolivia.swing.JCTextField studentidTF4;
    private javax.swing.JLabel stunameL;
    // End of variables declaration//GEN-END:variables
}
