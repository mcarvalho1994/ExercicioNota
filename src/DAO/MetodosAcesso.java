/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Address;
import Controller.ComboMultiData;
import Controller.Hotel;
import Controller.User;
import DAO.MySQLConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class MetodosAcesso
{
    // 1 - Login
    public User login (User user) throws SQLException, IOException
    {
        User u = new User();
        Connection conn = new MySQLConnection().getMySQLConnection();
        String sql = "select * from users where cpf = ? and password = ?";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getCpf());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.first())
            {
                System.out.println("Logado");
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setProfile(rs.getString("profile"));
                u.setAge(rs.getInt("age"));
                return u;
            }
            else
            {
                System.out.println("Não Logado");
                return null;
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return null;
        }
    }
    // 2 - List countries, states and cities
    public Vector <ComboMultiData> list(String type) throws SQLException
    {
        Connection conn = new MySQLConnection().getMySQLConnection();
        String field_id, field_name, field_where;
        Vector <ComboMultiData> v = new Vector();
        switch(type)
        {
            case "countries" :
                field_id = "country_id";
                field_name = "country_name";
                field_where = "country_id";
                break;
            case "states" :
                field_id = "state_id";
                field_name = "state_name";
                field_where = "country_id";
                break;
            case "cities" :
                field_id = "city_id";
                field_name = "city_name";
                field_where = "state_id";
                break;
            default :
                    field_id = "";
                    field_name = "";
                    field_where = "";
                    break;
        }
        String sql = "SELECT " + field_id + ", " + field_name + " FROM " + type;
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                v.addElement(new ComboMultiData(rs.getInt(field_id), rs.getString(field_name)));
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
        }
        return v;
    }
    
    // 3 - Overload List countries, states and cities
    public Vector<ComboMultiData> list(String type, int index) throws SQLException
    {
        Connection conn = new MySQLConnection().getMySQLConnection();
        String field_id, field_name, field_where;
        Vector <ComboMultiData> v = new Vector();
        
        switch(type)
        {
            case "countries" :
                field_id = "country_id";
                field_name = "country_name";
                field_where = "country_id";
                break;
            case "states" :
                field_id = "state_id";
                field_name = "state_name";
                field_where = "country_id";
                break;
            case "cities" :
                field_id = "city_id";
                field_name = "city_name";
                field_where = "state_id";
                break;
            default :
                    field_id = "";
                    field_name = "";
                    field_where = "";
                    break;
        }
        String sql = "SELECT " + field_id + ", " + field_name + " FROM " + type + " WHERE " + field_where + " = " + index;
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {                
                v.addElement(new ComboMultiData(rs.getInt(field_id), rs.getString(field_name)));
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
        }
        return v;
    }
    
    // 4 - Register User
    public boolean register(User user) throws SQLException
    {
        Connection conn = new MySQLConnection().getMySQLConnection();
        String sql = "INSERT INTO users(cpf, password, user_name, age, profile) VALUES (?, ?, ?, ?, ?) ";
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getCpf());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUser_name());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getProfile());
            
            stmt.execute();
            return true;
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return false;
        }       
    }
    
    // 5 - Add Address
    public boolean addAddress(Address a, String doc) throws SQLException
    {
        int id = 0;
        Connection conn = new MySQLConnection().getMySQLConnection();
        String sql_add_address_user = "INSERT INTO addresses(city_id, address, address_type, user_id) VALUES (?, ?, ?, ?)";
        String sql_add_address_hotel = "INSERT INTO addresses(city_id, address, address_type, hotel_id) VALUES (?, ?, ?, ?)";
        
        try
        {
            PreparedStatement stmt = null;
            if(a.getAddress_type().equals("U"))
            {
                id = returnId(doc, "U");

                stmt = conn.prepareStatement(sql_add_address_user);
                stmt.setInt(1, a.getCity());
                stmt.setString(2, a.getAddress());
                stmt.setString(3, a.getAddress_type());
                stmt.setInt(4, id);

                stmt.execute();
            }
            else
            {
                id = returnId(doc, "H");

                stmt = conn.prepareStatement(sql_add_address_hotel);
                stmt.setInt(1, a.getCity());
                stmt.setString(2, a.getAddress());
                stmt.setString(3, a.getAddress_type());
                stmt.setInt(4, id);

                stmt.execute();
            }
            
            return true;
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return false;
        }   
        
    }
    
    // 6 - Add Hotel
    public boolean addHotel(Hotel h, int user_id) throws SQLException
    {
        Connection conn = MySQLConnection.getMySQLConnection();
        String sql = "INSERT INTO hotels (hotel_name, cnpj, hotel_daily_rate, hotel_description, bedrooms_number, add_date, user_id)"
                + " VALUES (?, ?, ?, ?, ?, NOW(), ?)";
        try
        {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, h.getHotel_name());
            stmt.setString(2, h.getCnpj());
            stmt.setDouble(3, h.getHotel_daily_rate());
            stmt.setString(4, h.getHotel_description());
            stmt.setInt(5, h.getBedrooms_number());
            stmt.setInt(6, user_id);
            
            stmt.execute();
            return true;
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return false;
        }
        
    }
    
    // 7 - Returd user or hotel id
    public int returnId(String doc, String type) throws SQLException
    {
        Connection conn = MySQLConnection.getMySQLConnection();
        String sql_user_id = "SELECT user_id FROM users WHERE cpf = ?";
        String sql_hotel_id = "SELECT hotel_id FROM hotels WHERE cnpj = ?";
        int id = 0;
        PreparedStatement stmt = null;
        if(type.equals("U"))
        {
            stmt = conn.prepareStatement(sql_user_id);
            stmt.setString(1, doc);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                id = rs.getInt("user_id");
            }
        }
        else
        {
            stmt = conn.prepareStatement(sql_hotel_id);
            stmt.setString(1, doc);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                id = rs.getInt("hotel_id");
            }    
        }
        return id;
    }
    
    // 8 - add Hotel Photos
    public boolean addHotelPhotos(String path, int hotel_id) throws SQLException
    {
        Connection conn = MySQLConnection.getMySQLConnection();
        String sql = "INSERT INTO hotel_photos(hotel_id, photo_path) VALUES (?, ?)";
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hotel_id);
            stmt.setString(2, path);
            
            stmt.execute();
            return true;
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return false;
        }
    }
    
    // 9 - Load User Hotels
    public Vector<Hotel> load_user_hotels(int user_id) throws SQLException
    {
        Connection conn = MySQLConnection.getMySQLConnection();
        Vector<Hotel> v = new Vector<Hotel>();
        String sql_hotels = "SELECT * FROM hotels WHERE user_id = ? ORDER BY hotel_id";
        String sql_photos = "SELECT * FROM hotel_photos WHERE hotel_id = ?";
        
        try
        {
            PreparedStatement stmt_hotels = conn.prepareStatement(sql_hotels);
            stmt_hotels.setInt(1, user_id);
            ResultSet rs_hotels = stmt_hotels.executeQuery();

            while(rs_hotels.next())
            {
                Hotel h = new Hotel();
                Set<File> hotel_photos = new HashSet<File>();
                h.setHotel_id(rs_hotels.getInt("hotel_id"));
                h.setCnpj(rs_hotels.getString("cnpj"));
                h.setHotel_name(rs_hotels.getString("hotel_name"));
                h.setHotel_daily_rate(rs_hotels.getDouble("hotel_daily_rate"));
                h.setHotel_description(rs_hotels.getString("hotel_description"));
                h.setBedrooms_number(rs_hotels.getInt("bedrooms_number"));
                
                PreparedStatement stmt_photos = conn.prepareStatement(sql_photos);
                stmt_photos.setInt(1, rs_hotels.getInt("hotel_id"));
                ResultSet rs_photos = stmt_photos.executeQuery();
                while(rs_photos.next())
                {
                    hotel_photos.add(new File(rs_photos.getString("photo_path")));
                }
                h.setHotel_photos(hotel_photos);

                v.addElement(h);
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
        }
        return v;        
    }
    
    // 10 - Load Address
    public  Vector<Address> load_address(int id, String address_type) throws SQLException
    {
        Vector<Address> va = new Vector<Address>();
        Connection conn = MySQLConnection.getMySQLConnection();
        String field = "";
        String sql = "";
        
        switch(address_type)
        {
            case "H" :
                sql =   "select a.address, a.city_id, s.state_id, c.country_id from addresses a \n" +
                        "inner join hotels h on a.hotel_id = h.hotel_id\n" +
                        "inner join users u on h.user_id = u.user_id\n" +
                        "inner join cities ct on a.city_id = ct.city_id\n" +
                        "inner join states s on ct.state_id = s.state_id\n" +
                        "inner join countries c on s.country_id = c.country_id\n" +
                        "where u.user_id = ? and D_E_L_E_T_ IS NULL";
                break;
            case "U" :
                field = "user_id";
                sql = "SELECT a.address, ct.city_id, s.state_id,"
                + " cn.country_id FROM addresses a"
                + " INNER JOIN cities ct ON a.city_id = ct.city_id"
                + " INNER JOIN states s ON ct.state_id = s.state_id"
                + " INNER JOIN countries cn ON s.country_id = cn.country_id"
                + " WHERE " + field + " = ? and D_E_L_E_T_ IS NULL";
                break;
        }
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Address a = new Address();
                a.setAddress(rs.getString("address"));
                a.setCountry(rs.getInt("country_id"));
                a.setState(rs.getInt("state_id"));
                a.setCity(rs.getInt("city_id"));
                va.addElement(a);
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
        }
        return va;
    }
    
    // 11 - Get the city index for the state
    public int getCityIndex(int state_id, int city_id) throws SQLException
    {
        int id = 0;
        Connection conn = MySQLConnection.getMySQLConnection();
        String sql = "SELECT c.city_id, @rownum := @rownum + 1 AS row_number FROM cities c, (SELECT @rownum := 0) r" 
                    +" WHERE c.state_id = ?";
        
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, state_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                if(rs.getInt("city_id") == city_id)
                {
                    id = rs.getInt("row_number");
                }
            }
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
        }
        return id;
    }
    
    // 12 - Manage hotel
    public boolean manageHotel(Hotel h) throws SQLException
    {
        Connection conn = MySQLConnection.getMySQLConnection();
        String sql = "UPDATE HOTEL cnpj = ?, hotel_name = ?, hotel_daily_rate = ?,"
                + " hotel_description = ?, bedrooms_number = ?, last_updated = NOW() "
                + " WHERE hotel_id = ?";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, h.getCnpj());
            stmt.setString(2, h.getHotel_name());
            stmt.setDouble(3, h.getHotel_daily_rate());
            stmt.setString(4, h.getHotel_description());
            stmt.setInt(5, h.getBedrooms_number());
            stmt.setInt(6, h.getHotel_id());
            System.out.println(stmt);
            return true;
        }
        catch(SQLException e)
        {
            Calendar c = Calendar.getInstance();          
            
            try
            {
                PrintWriter out = new PrintWriter(new FileWriter("error.log"));
                out.println(c.getTime() + " - " + e.getMessage());
                out.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Erro durante gravação: " + ioe.getMessage());
            }
            return false;
        }      
    }
    
    // 13 - Remove Hotel Image
    public boolean removeHotelImage(String url)
    {
        return true;
    }
}