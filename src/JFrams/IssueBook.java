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
public class IssueBook extends javax.swing.JFrame {

    Color mouseExitColor = new Color(153,153,153);
    Color mouseEnterColor = new Color(0,0,0);
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
        String book_id = studentidTF2.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from book where id = ?");
            pstm.setString(1, book_id);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                bookidL.setText(rs.getString(1));
                booknameL.setText(rs.getString(2));
                bookauthorL.setText(rs.getString(3));
                bookquantityL.setText(rs.getString(4));                
            }
            else{
                jLabel19.setText("InValid Book Id");
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void getStudentDetails(){
        String student_id = studentidTF.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from student where id = ?");
            pstm.setString(1, student_id);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                stuidL.setText(rs.getString(1));
                stunameL.setText(rs.getString(2));
                stucontactL.setText(rs.getString(3));
                stuaddressL.setText(rs.getString(4));                
            }
            else{
                jLabel20.setText("InValid Student Id");                
            }
        }
        catch(Exception e){
            
        }
    }
    public boolean issueBook(){
        boolean is_issue = false;
        String book_id = studentidTF2.getText();
        String student_id = studentidTF.getText();
        String book_name = booknameL.getText();
        String student_name = stunameL.getText();
        java.util.Date issue_date = rSDateChooser1.getDatoFecha();
        java.util.Date due_date =  rSDateChooser2.getDatoFecha();
        
        long l1 = issue_date.getTime();
        java.sql.Date sql_issue_date = new java.sql.Date(l1);
        
        long l2 = due_date.getTime();
        java.sql.Date sql_due_date = new java.sql.Date(l2);     
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into issuebook(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)");
            pstm.setString(1, book_id);
            pstm.setString(2, book_name);
            pstm.setString(3, student_id);
            pstm.setString(4, student_name);
            pstm.setDate(5,  sql_issue_date);
            pstm.setDate(6,  sql_due_date);
            pstm.setString(7, "pending");     
            
            int row_count = pstm.executeUpdate();
            
            if(row_count > 0){
                is_issue = true;
            }
            else{
                is_issue = false;
            }
    
        }
        catch(Exception e){
            
        }
        return is_issue;
    }
    
    public void updateCount(){
        String book_id = studentidTF2.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("update book set quantity = quantity-1 where id = ?");
            pstm.setString(1, book_id);
            int rowcount = pstm.executeUpdate();
            
            if(rowcount > 0){
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                String book_quantity = bookquantityL.getText();
                int quantity = Integer.parseInt(book_quantity);
                quantity--;
                bookquantityL.setText(quantity+"");
            }
            else{
                JOptionPane.showMessageDialog(this, "Book Count not Updated");                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean isAlreadyIssued(){
        boolean is_already_issue = false;
        String book_id = studentidTF2.getText();
        String student_id = studentidTF.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from issuebook where book_id = ? and student_id = ? and status = ?");
            pstm.setString(1, book_id);
            pstm.setString(2, student_id);
            pstm.setString(3, "pending");
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                is_already_issue = true;
            }
            else{
                is_already_issue = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return is_already_issue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        rSDateChooserBeanInfo2 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        stuidL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        stunameL = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        stucontactL = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        stuaddressL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bookauthorL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookidL = new javax.swing.JLabel();
        booknameL = new javax.swing.JLabel();
        bookquantityL = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        studentidTF = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        studentidTF2 = new app.bolivia.swing.JCTextField();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Script MT Bold", 1, 44)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel4.setText("Student Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 110));

        jPanel5.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 400, 10));

        jLabel12.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel12.setText("Student id : ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 30));

        stuidL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        stuidL.setForeground(new java.awt.Color(0, 153, 0));
        jPanel2.add(stuidL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 230, 30));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel14.setText("Student name : ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 140, 30));

        stunameL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        stunameL.setForeground(new java.awt.Color(0, 153, 0));
        jPanel2.add(stunameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 260, 30));

        jLabel16.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel16.setText("Student contact : ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 150, 30));

        stucontactL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        stucontactL.setForeground(new java.awt.Color(0, 153, 0));
        jPanel2.add(stucontactL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 260, 30));

        jLabel18.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel18.setText("Student address : ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 160, 30));

        stuaddressL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        stuaddressL.setForeground(new java.awt.Color(0, 153, 0));
        jPanel2.add(stuaddressL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 260, 30));

        jLabel9.setBackground(new java.awt.Color(204, 255, 0));
        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 70, 60));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 21)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 153));
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 340, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 430, 720));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 44)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 390, 110));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 390, 10));

        bookauthorL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        bookauthorL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(bookauthorL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 250, 30));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel5.setText("Book id : ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 30));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel6.setText("Book name : ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, 30));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel7.setText("Book author : ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, 30));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel8.setText("Book quantity : ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 140, 30));

        bookidL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        bookidL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(bookidL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 230, 30));

        booknameL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        booknameL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(booknameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 250, 30));

        bookquantityL.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        bookquantityL.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(bookquantityL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 250, 30));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 21)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 153));
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 340, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 720));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Issue Book");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 360, 50));

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 80, -1));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel11.setText("Issue date :");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        studentidTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        studentidTF.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        studentidTF.setPhColor(new java.awt.Color(51, 51, 51));
        studentidTF.setPlaceholder("Enter Student Id ...");
        studentidTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentidTFFocusLost(evt);
            }
        });
        studentidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidTFActionPerformed(evt);
            }
        });
        jPanel6.add(studentidTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 250, -1));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel13.setText("Book Id :");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        studentidTF2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        studentidTF2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        studentidTF2.setPhColor(new java.awt.Color(51, 51, 51));
        studentidTF2.setPlaceholder("Enter Book Id ...");
        studentidTF2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentidTF2FocusLost(evt);
            }
        });
        studentidTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidTF2ActionPerformed(evt);
            }
        });
        jPanel6.add(studentidTF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 250, -1));

        rSDateChooser1.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setFormatoFecha("dd/MM/yyyy");
        rSDateChooser1.setFuente(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        rSDateChooser1.setMaximumSize(new java.awt.Dimension(1000, 1000));
        rSDateChooser1.setPlaceholder("Select issue date\n");
        rSDateChooser1.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel6.add(rSDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 260, -1));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel15.setText("Student Id :");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel17.setText("Due date :");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        rSDateChooser2.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser2.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser2.setFormatoFecha("dd/MM/yyyy\n");
        rSDateChooser2.setPlaceholder("Select due date ");
        jPanel6.add(rSDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 260, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonRectangle1.setText("ISSUE BOOK");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 510, 720));

        setSize(new java.awt.Dimension(1355, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void studentidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidTFActionPerformed

    private void studentidTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidTF2ActionPerformed

    private void studentidTF2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentidTF2FocusLost
        getBookDetails();
    }//GEN-LAST:event_studentidTF2FocusLost

    private void studentidTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentidTFFocusLost
        getStudentDetails();       
    }//GEN-LAST:event_studentidTFFocusLost

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        String book_quantity = bookquantityL.getText();
        int quantity = Integer.parseInt(book_quantity);
        if(quantity <= 0){
            JOptionPane.showMessageDialog(this, "This Book is not Available");
        }
        else{
            if(isAlreadyIssued() == false){
        
                if(issueBook() == true){
                    JOptionPane.showMessageDialog(this, "Book issued successfully");
                    updateCount();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Book not issued successfully");            
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "This Book is Already Issued to this Student");
            }
        }

    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookauthorL;
    private javax.swing.JLabel bookidL;
    private javax.swing.JLabel booknameL;
    private javax.swing.JLabel bookquantityL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JLabel stuaddressL;
    private javax.swing.JLabel stucontactL;
    private app.bolivia.swing.JCTextField studentidTF;
    private app.bolivia.swing.JCTextField studentidTF2;
    private javax.swing.JLabel stuidL;
    private javax.swing.JLabel stunameL;
    // End of variables declaration//GEN-END:variables
}
