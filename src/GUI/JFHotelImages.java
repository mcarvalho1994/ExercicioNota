/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Hotel;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Marcos
 */
public class JFHotelImages extends javax.swing.JFrame {

    /**
     * Creates new form JFHotelImages
     */
    private int vIndex = 0;
    private Hotel h;
    private Vector<File> vPath = new Vector<File>();
    private Set<File> hotel_photos;
    private Vector<String> deleted_photos = new Vector<String>();
    private Set<File> added_photos = new HashSet();
    private JFManageHotel jfmh;
    
    public void load_informations(Hotel h, JFManageHotel jfmh)
    {
        this.h = h;
        this.jfmh = jfmh;
        this.setTitle("Guia Hoteleiro - Imagens: " + this.h.getHotel_name());
        hotel_photos = h.getHotel_photos();
        for(File path : hotel_photos)
        {
            vPath.addElement(path);
        }
        display_hotel_images();
    }
    
    public void display_hotel_images()
    {
        ImageIcon icon = new ImageIcon(vPath.get(vIndex).getAbsolutePath());
        jLblImage.setIcon(icon);
        jLblPath.setText(vPath.get(vIndex).getAbsolutePath());
    }
    
    public JFHotelImages() {
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

        jLblPrevious = new javax.swing.JLabel();
        jLblNext = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jLblImage = new javax.swing.JLabel();
        jBtnRemoveImage = new javax.swing.JButton();
        jBtnAddNewImages = new javax.swing.JButton();
        jLblPath = new javax.swing.JLabel();
        jLblPhotoQuantity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLblPrevious.setText("<<");
        jLblPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblPreviousMouseClicked(evt);
            }
        });

        jLblNext.setText(">>");
        jLblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblNextMouseClicked(evt);
            }
        });

        jBtnSave.setText("Salvar todas as imagens");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jLblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jBtnRemoveImage.setText("Remover esta imagem");
        jBtnRemoveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoveImageActionPerformed(evt);
            }
        });

        jBtnAddNewImages.setText("Adicionar novas imagens");
        jBtnAddNewImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddNewImagesActionPerformed(evt);
            }
        });

        jLblPath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLblPhotoQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jLblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnRemoveImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAddNewImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblPhotoQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblNext)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRemoveImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAddNewImages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblPhotoQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addComponent(jLblPrevious, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblNext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblPreviousMouseClicked
        if(vIndex == 0)
        {
            JOptionPane.showMessageDialog(null, "Primeira Foto Cadastrada");
        }
        else
        {
            vIndex--;
            display_hotel_images();
        }
    }//GEN-LAST:event_jLblPreviousMouseClicked

    private void jLblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblNextMouseClicked
        if(vIndex == vPath.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "Última Foto Cadastrada");
        }
        else
        {
            vIndex++;
            display_hotel_images();
        }
    }//GEN-LAST:event_jLblNextMouseClicked

    private void jBtnRemoveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoveImageActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja excluir essa imagem?") == 0)
        {
            deleted_photos.add(vPath.get(vIndex).getAbsolutePath());
            vPath.remove(vIndex);
            JOptionPane.showMessageDialog(null, "Imagem removida com sucesso!");
            if((vIndex < hotel_photos.size()) && vIndex != 0)
            {
                vIndex = vIndex - 1;
            }
            display_hotel_images();
        }
    }//GEN-LAST:event_jBtnRemoveImageActionPerformed

    private void jBtnAddNewImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddNewImagesActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        jfc.setFileFilter(filter);
        
        int returnValue = jfc.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File[] files = jfc.getSelectedFiles();
            for(int i = 0; i < files.length; i++)
            {
                added_photos.add(files[i]);
            }
            
            if(files.length == 1)
                jLblPhotoQuantity.setText(String.valueOf(files.length) + " Nova Foto Selecionada");
            else if(files.length > 1)
                jLblPhotoQuantity.setText(String.valueOf(files.length) + " Novas Fotos Selecionadas");
        }
    }//GEN-LAST:event_jBtnAddNewImagesActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
    jfmh.load_photos_changes(added_photos, deleted_photos);
    this.dispose();
    }//GEN-LAST:event_jBtnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(JFHotelImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFHotelImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFHotelImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFHotelImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFHotelImages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddNewImages;
    private javax.swing.JButton jBtnRemoveImage;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JLabel jLblImage;
    private javax.swing.JLabel jLblNext;
    private javax.swing.JLabel jLblPath;
    private javax.swing.JLabel jLblPhotoQuantity;
    private javax.swing.JLabel jLblPrevious;
    // End of variables declaration//GEN-END:variables
}
