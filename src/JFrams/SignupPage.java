
package JFrams;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class SignupPage extends javax.swing.JFrame {

    public SignupPage() {
        initComponents();
        icon2.setVisible(false);
         }
    // method for to insert values from signup page to database
    public void insertSignuppageValues(){
        String uname = unameTF.getText();
        String upassword = upasswordTF.getText(); 
        String uemail = uemailTF.getText();  
    
        try{
            
        
            Connection con = DBConnection.getConnection();
          
            
            PreparedStatement pstm = con.prepareStatement("insert into user (name,password,email) values (?,?,?)");
        
            pstm.setString(1, uname);
            pstm.setString(2, upassword);
            pstm.setString(3, uemail);  
            
            int updatedRowCount = pstm.executeUpdate();
            
            if(updatedRowCount > 0 ){
                JOptionPane.showMessageDialog(this,"User Recorded Successfully");
                LoginPage page = new LoginPage();
                page.setVisible(true);
                this.dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"User Recorded Not Successfully");                
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public boolean fillInfo(){
        String uname = unameTF.getText();
        String upassword = upasswordTF.getText(); 
        String uemail = uemailTF.getText();  

        if(uname.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the user name");
            return false;
        }
        if(upassword.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the user password");
            return false;
        }
        if(uemail.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the user email");
            return false;
        }
        if(!uemail.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this,"Please enter the Valid email");
            return false;
        }        
        
        return true;
    }
    
    public boolean checkDuplicateValues(){
        
        String uemail = uemailTF.getText(); 
        boolean exist = false;
        try{
            Connection con = DBConnection.getConnection(); 
            PreparedStatement pstm= con.prepareStatement("select * from user where email = ? ");
            pstm.setString(1, uemail);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                exist = true;
            }
            else{
                exist = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return exist;
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        unameTF = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        uemailTF = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jLabel9 = new javax.swing.JLabel();
        upasswordTF = new javax.swing.JPasswordField();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(990, 830));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 151, 192));
        jLabel1.setText("Shahvez Information & Technology Library");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 86, 90));
        jLabel2.setText("Welcome To");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup-library-icon.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 780, 640));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jPanel1.setBackground(new java.awt.Color(51, 126, 186));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 2, new java.awt.Color(0, 167, 158)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("create new account here");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel6.setBackground(new java.awt.Color(204, 255, 0));
        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 70, 60));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 50, 60));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("username");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        unameTF.setBackground(new java.awt.Color(51, 126, 186));
        unameTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        unameTF.setForeground(new java.awt.Color(204, 255, 204));
        unameTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unameTF.setPlaceholder("Enter username...");
        unameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameTFActionPerformed(evt);
            }
        });
        jPanel1.add(unameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 250, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 50, 60));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Password");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 50, 60));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        uemailTF.setBackground(new java.awt.Color(51, 126, 186));
        uemailTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        uemailTF.setForeground(new java.awt.Color(204, 255, 204));
        uemailTF.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        uemailTF.setPlaceholder("Enter Email...");
        uemailTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                uemailTFFocusLost(evt);
            }
        });
        uemailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uemailTFActionPerformed(evt);
            }
        });
        jPanel1.add(uemailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 86, 90));
        rSMaterialButtonCircle3.setText("SIGNUP");
        rSMaterialButtonCircle3.setFont(new java.awt.Font("Century Schoolbook", 1, 17)); // NOI18N
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 180, 60));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Signup Page");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        upasswordTF.setBackground(new java.awt.Color(51, 126, 186));
        upasswordTF.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        upasswordTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(upasswordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 220, 40));

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-show-password-50.png"))); // NOI18N
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon1MouseClicked(evt);
            }
        });
        jPanel1.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, 50));

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-private-lock-50.png"))); // NOI18N
        icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon2MouseClicked(evt);
            }
        });
        jPanel1.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 60, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 450, 820));

        setSize(new java.awt.Dimension(1350, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameTFActionPerformed

    private void uemailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uemailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uemailTFActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(fillInfo() == true ) {
            if(checkDuplicateValues()== false){
                insertSignuppageValues();
            }
            else{
                JOptionPane.showMessageDialog(this, "This Email Already Exist");
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void uemailTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uemailTFFocusLost
     //   if(checkDuplicateValues() == true){
       //     JOptionPane.showMessageDialog(this,"This Email is Already Exist ...");
        //}
    }//GEN-LAST:event_uemailTFFocusLost

    private void icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MouseClicked
        upasswordTF.setEchoChar((char)0);
        icon1.setVisible(false);
        icon2.setVisible(true);

    }//GEN-LAST:event_icon1MouseClicked

    private void icon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon2MouseClicked
        upasswordTF.setEchoChar('*');
        icon2.setVisible(false);
        icon1.setVisible(true);
    }//GEN-LAST:event_icon2MouseClicked

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField uemailTF;
    private app.bolivia.swing.JCTextField unameTF;
    private javax.swing.JPasswordField upasswordTF;
    // End of variables declaration//GEN-END:variables
}
