/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrams;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class IssuedBookDetails extends javax.swing.JFrame {

    Color mouseExitColor = new Color(153,153,153);
    Color mouseEnterColor = new Color(0,0,0);
    
    Color mouseExitColor2 = new Color(0,204,204);
    Color mouseEnterColor2 = new Color(255,0,0);
    
    
    public IssuedBookDetails() {
        initComponents();
        getStudentData();
    }
    
    
    
    public void getStudentData(){
        DefaultTableModel model;
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from issuebook");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                String id = rs.getString(1);
                String student_name = rs.getString(5);
                String book_name = rs.getString(3);
                java.util.Date issue = rs.getDate(6);
                String issue_date = issue.toString();
                java.util.Date due = rs.getDate(7);
                String due_date = due.toString();

                String status = rs.getString(8);

                
                Object obj[] = {id,student_name,book_name,issue_date,due_date,status};
                model = (DefaultTableModel)table6.getModel();
                model.addRow(obj);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void clearTable(){
       

        DefaultTableModel model = (DefaultTableModel)table6.getModel();
        model.setRowCount(0);
    }    
    public void searchData(){
        
        boolean is_exist = false;
     
        java.util.Date initial_date = rSDateChooser3.getDatoFecha();
        java.util.Date final_date = rSDateChooser4.getDatoFecha();
        
        long l1 = initial_date.getTime();
        long l2 = final_date.getTime();
        
        java.sql.Date issue_date = new java.sql.Date(l1);
        java.sql.Date due_date = new java.sql.Date(l2);
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from issuebook where issue_date between ? and ?");
            pstm.setDate(1, issue_date);
            pstm.setDate(2, due_date);
            ResultSet rs = pstm.executeQuery();
 

 
                    while(rs.next()){
                    DefaultTableModel model;
                    String id = rs.getString(1);
                    String student_name = rs.getString(5);
                    String book_name = rs.getString(3);
                    java.util.Date issue = rs.getDate(6);
                    String issuedate = issue.toString();
                    java.util.Date due = rs.getDate(7);
                    String duedate = due.toString();

                    String status = rs.getString(8);

                
                    Object obj[] = {id,student_name,book_name,issuedate,duedate,status};
                    model = (DefaultTableModel)table6.getModel();
                    model.addRow(obj);
                    is_exist = true;
          
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(is_exist == false){
            JOptionPane.showMessageDialog(this, "Between these Dates There is No Record");
        }
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        rSPopuMenu1 = new rojeru_san.complementos.RSPopuMenu();
        rSPopuMenu2 = new rojeru_san.complementos.RSPopuMenu();
        materialShadowCircle1 = new efectos.MaterialShadowCircle();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jLabel12 = new javax.swing.JLabel();
        rSDateChooser3 = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel13 = new javax.swing.JLabel();
        rSDateChooser4 = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table6 = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 80, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 110, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 70, 50));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 70, 50));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel4.setText("Book Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 460, 120));

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 430, 10));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel11.setText("Issue date :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        rSDateChooser1.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setFormatoFecha("yyyy/MM/dd\n");
        rSDateChooser1.setFuente(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        rSDateChooser1.setPlaceholder("Select issue date\n");
        jPanel2.add(rSDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 260, -1));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel12.setText("Initial date :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        rSDateChooser3.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser3.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser3.setFormatoFecha("yyyy/MM/dd  ");
        rSDateChooser3.setFuente(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        rSDateChooser3.setPlaceholder("Select issue date\n");
        jPanel2.add(rSDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 260, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 0, 102));
        rSMaterialButtonRectangle1.setText("SEARCH");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 170, 180, 60));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 19)); // NOI18N
        jLabel13.setText("Final date :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        rSDateChooser4.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser4.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser4.setFormatoFecha("yyyy/MM/dd  ");
        rSDateChooser4.setFuente(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        rSDateChooser4.setPlaceholder("Select issue date\n");
        jPanel2.add(rSDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 260, -1));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 0, 102));
        rSMaterialButtonRectangle2.setText("ALL");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 230, 180, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 310));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Student Name", "Book Name", "Issue Date", "Due Date", "Status"
            }
        ));
        table6.setColorBackgoundHead(new java.awt.Color(0, 0, 102));
        table6.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table6.setColorSelBackgound(new java.awt.Color(255, 204, 51));
        table6.setColorSelForeground(new java.awt.Color(0, 0, 0));
        table6.setFont(new java.awt.Font("Segoe Print", 1, 15)); // NOI18N
        table6.setFuenteFilas(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        table6.setFuenteFilasSelect(new java.awt.Font("Tempus Sans ITC", 1, 19)); // NOI18N
        table6.setFuenteHead(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        table6.setMaximumSize(new java.awt.Dimension(700, 60));
        table6.setRowHeight(35);
        table6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table6MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table6);
        if (table6.getColumnModel().getColumnCount() > 0) {
            table6.getColumnModel().getColumn(0).setMinWidth(80);
            table6.getColumnModel().getColumn(0).setMaxWidth(80);
            table6.getColumnModel().getColumn(1).setMinWidth(300);
            table6.getColumnModel().getColumn(1).setMaxWidth(300);
            table6.getColumnModel().getColumn(2).setMinWidth(300);
            table6.getColumnModel().getColumn(2).setMaxWidth(300);
            table6.getColumnModel().getColumn(5).setMinWidth(150);
            table6.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 1160, 380));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1360, 410));

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jPanel4.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jPanel6.setBackground(mouseEnterColor2);
        jLabel3.setForeground(mouseExitColor2);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jPanel6.setBackground(mouseExitColor2);
        jLabel3.setForeground(mouseEnterColor2);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void table6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseClicked
    }//GEN-LAST:event_table6MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        clearTable(); 
        searchData(); 
        
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        clearTable(); 
        getStudentData();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private efectos.MaterialShadowCircle materialShadowCircle1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser3;
    private rojeru_san.componentes.RSDateChooser rSDateChooser4;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojeru_san.complementos.RSPopuMenu rSPopuMenu1;
    private rojeru_san.complementos.RSPopuMenu rSPopuMenu2;
    private rojeru_san.complementos.RSTableMetro table6;
    // End of variables declaration//GEN-END:variables

  
}
