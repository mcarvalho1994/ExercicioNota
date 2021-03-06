/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Address;
import Controller.CNPJNotValidException;
import Controller.CharacterLimitException;
import Controller.ComboMultiData;
import Controller.Hotel;
import Controller.User;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Marcos
 */
public class JFManageHotel extends javax.swing.JFrame {

    /**
     * Creates new form JFManageHotel
     */
    
    private User user;
    private Set<File> photos = new HashSet();
    private int vIndex = 0;
    private Vector<Hotel> vh = new Vector<Hotel>();
    private Vector<Address> va = new Vector<Address>();
    private Address a = new Address();
    private Vector<String> deleted_photos = new Vector<String>();
    private Set<File> added_photos = new HashSet();
    
    
    public void load_user(User user) throws SQLException
    {
        this.user = user;
        load_user_hotels();
    }
    
    public void fulfillComponents(String type) throws SQLException
    {
        Vector <ComboMultiData> v = new Vector();
        Address address = new Address();
        v = address.list(type);
        DefaultComboBoxModel model = new DefaultComboBoxModel(v);
        switch(type)
        {
            case "countries" :
                jComboCountries.setModel(model);
                break;
            case "states" :
                jComboStates.setModel(model);
                break;
            case "cities" :
                jComboCities.setModel(model);
                break;
        }
    }
    
    public void fulfillComponents(String type, int index) throws SQLException
    {
        Vector <ComboMultiData> v = new Vector();
        Address address = new Address();
        v = address.list(type, index);
        DefaultComboBoxModel model = new DefaultComboBoxModel(v);
        switch(type)
        {
            case "countries" :
                jComboCountries.setModel(model);
                break;
            case "states" :
                jComboStates.setModel(model);
                break;
            case "cities" :
                jComboCities.setModel(model);
                break;
        }
    }
    
    public void cleanComponents()
    {
        jTxtCNPJ.setText("");
        jTxtAreaDrescription.selectAll();
        jTxtAreaDrescription.setText("");
        jTxtBedroomsNumber.setText("");
        jTxtHotelDailyRate.setText("");
        jTxtHotelName.setText("");
        jTxtAddress.setText("");
        jComboCountries.setSelectedIndex(0);
        jComboStates.setSelectedIndex(0);
        jComboCities.setSelectedIndex(0);
    }
    
    public void load_user_hotels() throws SQLException
    {      
        vh = this.user.load_user_hotels();
        va = a.loadAddress("H", user.getUser_id());
        display_user_hotel();
        
    }
    
    public void display_user_hotel() throws SQLException
    {
        int city_index;
        jTxtCNPJ.setText(vh.get(vIndex).getCnpj());
        jTxtHotelName.setText(vh.get(vIndex).getHotel_name());
        jTxtAreaDrescription.selectAll();
        jTxtAreaDrescription.setText(vh.get(vIndex).getHotel_description());
        jTxtBedroomsNumber.setText(String.valueOf(vh.get(vIndex).getBedrooms_number()));
        jTxtHotelDailyRate.setText(String.valueOf(vh.get(vIndex).getHotel_daily_rate()).replace(".", ","));
        jTxtAddress.setText(va.get(vIndex).getAddress());
        jComboCountries.setSelectedIndex(va.get(vIndex).getCountry() - 1);
        jComboStates.setSelectedIndex(va.get(vIndex).getState() - 1);
        city_index = va.get(vIndex).getCityIndex(va.get(vIndex).getState(), va.get(vIndex).getCity());
        jComboCities.setSelectedIndex(city_index - 1);
        jLblPhotoQuantity.setText(String.valueOf(vh.get(vIndex).getHotel_photos().size()));  
    }
    
    public void load_photos_changes(Set<File> added_photos, Vector<String> deleted_photos)
    {
        jLblPhotoQuantity.setText(String.valueOf(vh.get(vIndex).getHotel_photos().size() - deleted_photos.size() 
                + added_photos.size()));
        this.deleted_photos = deleted_photos;
        this.added_photos = added_photos;
    }
    
    public JFManageHotel() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        jComboCountries.removeAllItems();
        jComboStates.removeAllItems();
        jComboCities.removeAllItems();
        jComboCountries.addItem("- Selecione um país -");
        fulfillComponents("countries");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtBedroomsNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtHotelDailyRate = new javax.swing.JTextField();
        jTxtAddress = new javax.swing.JTextField();
        jComboCountries = new javax.swing.JComboBox<>();
        jComboStates = new javax.swing.JComboBox<>();
        jComboCities = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLblPrevious = new javax.swing.JLabel();
        jLblNext = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtCNPJ = new javax.swing.JTextField();
        jTxtHotelName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtAreaDrescription = new java.awt.TextArea();
        jLabel10 = new javax.swing.JLabel();
        jBtnAlterImages = new javax.swing.JButton();
        jLblPhotoQuantity = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jBtnClean = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Guia Hoteleiro - Alterar Hotel");
        setResizable(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Máximo de 1000 caracteres");
        jLabel8.setToolTipText("");

        jLabel3.setText("Num. Quartos");

        jLabel5.setText("País");

        jComboCountries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboCountries.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboCountriesItemStateChanged(evt);
            }
        });

        jComboStates.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboStates.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboStatesItemStateChanged(evt);
            }
        });

        jComboCities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Diária - R$");

        jLabel6.setText("Estado");

        jLblPrevious.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblPrevious.setText("<< Anterior");
        jLblPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblPreviousMouseClicked(evt);
            }
        });

        jLblNext.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblNext.setText("Próximo >>");
        jLblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblNextMouseClicked(evt);
            }
        });

        jLabel9.setText("CNPJ");

        jLabel1.setText("Nome do Hotel");

        jLabel2.setText("Descrição");

        jLabel7.setText("Cidade");

        jTxtAreaDrescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel10.setText("Endereço");

        jBtnAlterImages.setText("Alterar/ Adicionar Imagens");
        jBtnAlterImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterImagesActionPerformed(evt);
            }
        });

        jLblPhotoQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblPhotoQuantity.setText("Nenhuma foto selecionada");

        jBtnSave.setText("Salvar");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jBtnClean.setText("Limpar");
        jBtnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCleanActionPerformed(evt);
            }
        });

        jBtnExit.setText("Sair");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLblNext))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnClean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLblPhotoQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnAlterImages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboCities, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboStates, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboCountries, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtHotelDailyRate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtBedroomsNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtHotelName)
                            .addComponent(jTxtCNPJ)
                            .addComponent(jTxtAreaDrescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPrevious)
                    .addComponent(jLblNext))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtHotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtAreaDrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtBedroomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtHotelDailyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboStates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboCities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterImages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblPhotoQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblNextMouseClicked
        if(vIndex == vh.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "Último Hotel Cadastrado");
        }
        else
        {
            vIndex++;
            try
            {
                display_user_hotel();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jLblNextMouseClicked

    private void jLblPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblPreviousMouseClicked
        if(vIndex == 0)
        {
            JOptionPane.showMessageDialog(null, "Primeiro Hotel Cadastrado");
        }
        else
        {
            vIndex--;
            try
            {
                display_user_hotel();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jLblPreviousMouseClicked

    private void jComboStatesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboStatesItemStateChanged
        int index = jComboStates.getSelectedIndex() + 1;
        try
        {
            fulfillComponents("cities", index);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboStatesItemStateChanged

    private void jComboCountriesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboCountriesItemStateChanged
        int index = jComboCountries.getSelectedIndex() + 1;
        try
        {
            fulfillComponents("states", index);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jComboCountriesItemStateChanged

    private void jBtnAlterImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterImagesActionPerformed
        JFHotelImages jfhi = new JFHotelImages();
        jfhi.load_informations(vh.get(vIndex), this);
        jfhi.show();
    }//GEN-LAST:event_jBtnAlterImagesActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        try
        {
            //Fulfilling the Hotel Object
            vh.get(vIndex).setCnpj(jTxtCNPJ.getText());
            vh.get(vIndex).setHotel_name(jTxtHotelName.getText());
            vh.get(vIndex).setHotel_description(jTxtAreaDrescription.getText());
            if(jTxtBedroomsNumber.getText().isEmpty())
                vh.get(vIndex).setBedrooms_number(0);
            else
                vh.get(vIndex).setBedrooms_number(Integer.parseInt(jTxtBedroomsNumber.getText()));
            if(jTxtHotelDailyRate.getText().isEmpty())
                vh.get(vIndex).setHotel_daily_rate(0.00);
            else
                vh.get(vIndex).setHotel_daily_rate(Double.parseDouble(jTxtHotelDailyRate.getText().replace(",", ".")));
            
            //Fulfilling the Address Object
            va.get(vIndex).setAddress(jTxtAddress.getText());
            va.get(vIndex).setCity(((ComboMultiData)jComboCities.getSelectedItem()).getValue());
            va.get(vIndex).setAddress_type("H");
            
            //Saving at the database
            if(vh.get(vIndex).manageHotel(vh.get(vIndex)))
            {
                if(va.get(vIndex).manageAddress(va.get(vIndex), vh.get(vIndex).getHotel_id(), "H"))
                {
                    if(vh.get(vIndex).removeHotelImages(deleted_photos))
                    {
                        if(vh.get(vIndex).addHotelPhotos(added_photos, vh.get(vIndex).getHotel_id()))
                        {
                            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
                            this.dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Alteração falhou!");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Alteração falhou!");
                }
                else
                    JOptionPane.showMessageDialog(null, "Alteração falhou!");
            }
            else
                JOptionPane.showMessageDialog(null, "Alteração falhou!");
        }
        catch (CNPJNotValidException | CharacterLimitException |SQLException | IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jBtnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCleanActionPerformed
        cleanComponents();
    }//GEN-LAST:event_jBtnCleanActionPerformed

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnExitActionPerformed

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
            java.util.logging.Logger.getLogger(JFManageHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFManageHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFManageHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFManageHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    new JFManageHotel().setVisible(true);
                    
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(JFManageHotel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterImages;
    private javax.swing.JButton jBtnClean;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JComboBox<String> jComboCities;
    private javax.swing.JComboBox<String> jComboCountries;
    private javax.swing.JComboBox<String> jComboStates;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jLblNext;
    private javax.swing.JLabel jLblPhotoQuantity;
    private javax.swing.JLabel jLblPrevious;
    private javax.swing.JTextField jTxtAddress;
    private java.awt.TextArea jTxtAreaDrescription;
    private javax.swing.JTextField jTxtBedroomsNumber;
    private javax.swing.JTextField jTxtCNPJ;
    private javax.swing.JTextField jTxtHotelDailyRate;
    private javax.swing.JTextField jTxtHotelName;
    // End of variables declaration//GEN-END:variables
}
