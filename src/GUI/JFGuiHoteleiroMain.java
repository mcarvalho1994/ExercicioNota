/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class JFGuiHoteleiroMain extends javax.swing.JFrame {

    /**
     * Creates new form JFGuiHoteleiroMain
     */
    private String user_profile = "";
    private User user = null;
    
    public void disable_functions_by_userProfile()
    {
        if(user_profile.equals("U"))
        {
            jMenuAddHotel.setVisible(false);
            jMenuAlterHotel.setVisible(false);
        }
    }
    
    public void load_user(User user)
    {
        this.user = user;
        user_profile = this.user.getProfile();
        jLblUserName.setText("Bem vindo(a) " + this.user.getUser_name() + "!");
        disable_functions_by_userProfile();
    }
    
    public JFGuiHoteleiroMain() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblUserName = new javax.swing.JLabel();
        jLblLogOut = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHotel = new javax.swing.JMenu();
        jMenuAddHotel = new javax.swing.JMenuItem();
        jMenuAlterHotel = new javax.swing.JMenuItem();
        jMenuSearchHotel = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guia Hoteleiro - Home");
        setResizable(false);

        jLblLogOut.setText("Logout");
        jLblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblLogOutMouseClicked(evt);
            }
        });

        jMenuHotel.setText("Hotel");

        jMenuAddHotel.setText("Adicionar Hotel");
        jMenuAddHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAddHotelActionPerformed(evt);
            }
        });
        jMenuHotel.add(jMenuAddHotel);

        jMenuAlterHotel.setText("Alterar Hotel");
        jMenuAlterHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlterHotelActionPerformed(evt);
            }
        });
        jMenuHotel.add(jMenuAlterHotel);

        jMenuSearchHotel.setText("Procurar Hotel");
        jMenuSearchHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSearchHotelActionPerformed(evt);
            }
        });
        jMenuHotel.add(jMenuSearchHotel);

        jMenuBar.add(jMenuHotel);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblLogOut, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLblLogOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAddHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAddHotelActionPerformed
        JFAddHotel jfah;
        try
        {
            jfah = new JFAddHotel();
            jfah.load_user(this.user);
            jfah.show();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_jMenuAddHotelActionPerformed

    private void jMenuAlterHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlterHotelActionPerformed
        JFManageHotel jfmh;
        try
        {
            jfmh = new JFManageHotel();
            jfmh.load_user(this.user);
            jfmh.show();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jMenuAlterHotelActionPerformed

    private void jMenuSearchHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSearchHotelActionPerformed
        JFSearchHotel jfsh = new JFSearchHotel();
        jfsh.load_user(user);
        jfsh.show();
    }//GEN-LAST:event_jMenuSearchHotelActionPerformed

    private void jLblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblLogOutMouseClicked
        JFLogin jfl = new JFLogin();
        this.dispose();
        jfl.show();
    }//GEN-LAST:event_jLblLogOutMouseClicked

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
            java.util.logging.Logger.getLogger(JFGuiHoteleiroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFGuiHoteleiroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFGuiHoteleiroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFGuiHoteleiroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFGuiHoteleiroMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblLogOut;
    private javax.swing.JLabel jLblUserName;
    private javax.swing.JMenuItem jMenuAddHotel;
    private javax.swing.JMenuItem jMenuAlterHotel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHotel;
    private javax.swing.JMenuItem jMenuSearchHotel;
    // End of variables declaration//GEN-END:variables
}
