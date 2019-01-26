/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hélio
 */
public class JPanelResults extends JPanel
{
    
    public JPanelResults(Hotel h, int y)
    {
        /*
        JPanelResults properties
        */
        setLayout(new GridLayout(0, 4));
        setBounds(0, y, 500, 100);
        
        /*
        Another Panels
        */
        //Image Panel
        JPanel jPanelImage = new JPanel();
        jPanelImage.setBounds(0, y, 100, 100);
        String path_url = "";
        for(File file : h.getHotel_photos())
        {
            path_url = file.getAbsolutePath();
        }
        JLabel jLblImage = new JLabel();
        ImageIcon icon = new ImageIcon(path_url);
        jLblImage.setIcon(icon);
        jPanelImage.add(jLblImage);
        //Hotel description  Panel
        JPanel jPanelHotelDescription = new JPanel();
        JLabel jLblHotelDescription = new JLabel(h.getHotel_name() + " - " + h.getHotel_description());
        jPanelHotelDescription.add(jLblHotelDescription);
        //Hotel Daily Rate Panel
        JPanel jPanelHotelDailyRate = new JPanel();
        JLabel jLblHotelDailyRate = new JLabel(String.valueOf(h.getHotel_daily_rate()).replace(".", ","));
        jPanelHotelDailyRate.add(jLblHotelDailyRate);
        //Add a comment Panel
        JPanel jPanelAddComment = new JPanel();
        JLabel jLblAddComment = new JLabel("Adicione um comentário");
        jLblAddComment.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null, "Ainda não implementado");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            }
        });
        jPanelAddComment.add(jLblAddComment);
        /*
        Adding the other panels to the JPanelResults
        */
        this.add(jPanelImage);
        this.add(jPanelHotelDescription);
        this.add(jPanelHotelDailyRate);
        this.add(jPanelAddComment);
    }
    
}
