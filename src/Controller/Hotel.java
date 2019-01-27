/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MetodosAcesso;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class Hotel
{
    private int hotel_id;
    private String hotel_name;
    private String cnpj;
    private Double hotel_daily_rate;
    private String hotel_description;
    private int bedrooms_number;
    private Set<File> hotel_photos;

        /**
     * @return the hotel_id
     */
    public int getHotel_id() {
        return hotel_id;
    }

    /**
     * @param hotel_id the hotel_id to set
     */
    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    /**
     * @return the hotel_name
     */
    public String getHotel_name() {
        return hotel_name;
    }

    /**
     * @param hotel_name the hotel_name to set
     */
    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }
    
        /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the hotel_daily_rate
     */
    public Double getHotel_daily_rate() {
        return hotel_daily_rate;
    }

    /**
     * @param hotel_daily_rate the hotel_daily_rate to set
     */
    public void setHotel_daily_rate(Double hotel_daily_rate) {
        this.hotel_daily_rate = hotel_daily_rate;
    }

    /**
     * @return the hotel_description
     */
    public String getHotel_description() {
        return hotel_description;
    }

    /**
     * @param hotel_description the hotel_description to set
     */
    public void setHotel_description(String hotel_description) {
        this.hotel_description = hotel_description;
    }

    /**
     * @return the bedrooms_number
     */
    public int getBedrooms_number() {
        return bedrooms_number;
    }

    /**
     * @param bedrooms_number the bedrooms_number to set
     */
    public void setBedrooms_number(int bedrooms_number) {
        this.bedrooms_number = bedrooms_number;
    }

    /**
     * @return the hotel_photos
     */
    public Set<File> getHotel_photos() {
        return hotel_photos;
    }

    /**
     * @param hotel_photos the hotel_photos to set
     */
    public void setHotel_photos(Set<File> hotel_photos) {
        this.hotel_photos = hotel_photos;
    }
    
    public boolean addHotel(Hotel h,int user_id) throws CNPJNotValidException, CharacterLimitException, SQLException, IOException
    {
        int id;
        if(validateCNPJ() && validateCharacterNumber())
        {
            MetodosAcesso mtd = new MetodosAcesso();
            
            if(mtd.addHotel(h, user_id))
            {
                return addHotelPhotos(h.getHotel_photos(), mtd.returnId(h.getCnpj(), "H"));
            }
            else
                return false;
        }
        else
            return false;        
    }
    
    public boolean manageHotel(Hotel h) throws CNPJNotValidException, CharacterLimitException, SQLException
    {
        if(validateCNPJ() && validateCharacterNumber())
        {
            MetodosAcesso mtd = new MetodosAcesso();
            mtd.manageHotel(h);
            return true;
        }
        else
            return false;
        
    }
    
    public boolean addHotelPhotos(Set<File> hotel_photos, int id) throws IOException, SQLException
    {   
        File filefolder = new File("c:\\hotel_photos\\" + String.valueOf(id) + "\\");
        filefolder.mkdirs();
        MetodosAcesso mtd = new MetodosAcesso();

        for(File path : hotel_photos)
        {
            File new_file = new File("c:\\hotel_photos\\" + String.valueOf(id) + "\\" + path.getName());
            copyFile(path.getAbsoluteFile(), new_file);
            mtd.addHotelPhotos(new_file.getAbsolutePath(), id);
        }
        return true;
    }
    
    public static void copyFile(File source, File destination) throws IOException
    {
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try
        {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        }
        finally
        {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
        }
   }
    
    public boolean validateCNPJ() throws CNPJNotValidException
    {
        if (this.cnpj.equals("00000000000000") ||
            this.cnpj.equals("11111111111111") ||
            this.cnpj.equals("22222222222222") || this.cnpj.equals("33333333333333") ||
            this.cnpj.equals("44444444444444") || this.cnpj.equals("55555555555555") ||
            this.cnpj.equals("66666666666666") || this.cnpj.equals("77777777777777") ||
            this.cnpj.equals("88888888888888") || this.cnpj.equals("99999999999999") ||
            (this.cnpj.length() != 14))
        {
            throw new CNPJNotValidException();
        }
        return true;
    }
    
    public boolean validateCharacterNumber() throws CharacterLimitException
    {
        if (hotel_description.length() >= 1000)
        {
            throw new CharacterLimitException();
        }
        return true;
    }    
    
    public boolean removeHotelImages(Vector<String> url) throws SQLException
    {
        MetodosAcesso mtd = new MetodosAcesso();
        return mtd.removeHotelImages(url);
    }
    
    public Vector<Hotel> searchHotel(char search_type, String search) throws SQLException
    {
        Vector<Hotel> hotel_list = new Vector<Hotel>();
        MetodosAcesso mtd = new MetodosAcesso();
        /*
        Search type n = hotel name
        Search type a = Adress
        */
        return hotel_list = mtd.searchHotel(search_type, search);
    }
}
