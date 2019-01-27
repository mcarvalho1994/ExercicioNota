/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Address;
import Controller.Hotel;
import Controller.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class JPanelResults extends JPanel
{
    
    public JPanelResults(Hotel h, Address a, int y, User user)
    {
        /*
        JPanelResults properties
        */
        setLayout(new GridLayout(0, 6));
        setBounds(0, y, 500, 100);
        
        /*
        Another Panels
        */
        //Image Panel
        JPanel jPanelImage = new JPanel();
        String path_url = "";
        for(File file : h.getHotel_photos())
        {
            path_url = file.getAbsolutePath();
        }
        JLabel jLblImage = new JLabel();
        ImageIcon icon = new ImageIcon(path_url);
        jLblImage.setIcon(icon);
        jPanelImage.add(jLblImage);
        //Hotel name  Panel
        JPanel jPanelHotelName = new JPanel();
        JLabel jLblHotelName = new JLabel(h.getHotel_name());
        jPanelHotelName.add(jLblHotelName);
        //Address Panel
        JPanel jPanelAddress = new JPanel();
        JLabel jLblAddress = new JLabel(a.getAddress() + " " + a.getCity_name());
        jPanelAddress.add(jLblAddress);
        //Country and State Panel
        JPanel jPanelCAndE = new JPanel();
        JLabel jLblCandE = new JLabel(a.getState_name() + " - " + a.getCountry_name());
        jPanelCAndE.add(jLblCandE);
        //Hotel Daily Rate Panel
        JPanel jPanelHotelDailyRate = new JPanel();
        JLabel jLblHotelDailyRate = new JLabel("R$ " + String.valueOf(h.getHotel_daily_rate()).replace(".", ","));
        jPanelHotelDailyRate.add(jLblHotelDailyRate);
        //Add a comment Panel
        JPanel jPanelAddComment = new JPanel();
        JLabel jLblAddComment = new JLabel("Adicione um comentário");
        jLblAddComment.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JFAddComment jfac = new JFAddComment();
                jfac.load_informations(user, h);
                jfac.show();
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
        this.add(jPanelHotelName);
        this.add(jPanelAddress);
        this.add(jPanelCAndE);
        this.add(jPanelHotelDailyRate);
        this.add(jPanelAddComment);
    }
    
}
