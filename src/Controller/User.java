/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MetodosAcesso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Carvalho
 */
public class User
{
    private int user_id;
    private String cpf;
    private String user_name;
    private int age;
    private String password;
    private String profile;

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    public User login(User user) throws SQLException, IOException
    {
        User u = new User();
        MetodosAcesso mtd = new MetodosAcesso();
        u = mtd.login(user);
        return u;        
    }
    
    public boolean register(User user) throws CPFNotValidException, SQLException
    {
        if(validateCPF())
        {
            MetodosAcesso mtd = new MetodosAcesso();
            mtd.register(user);
        }
        return true;
    }
    
    public boolean validateCPF() throws CPFNotValidException
    {
        if (this.cpf.equals("00000000000") ||
            this.cpf.equals("11111111111") ||
            this.cpf.equals("22222222222") || this.cpf.equals("33333333333") ||
            this.cpf.equals("44444444444") || this.cpf.equals("55555555555") ||
            this.cpf.equals("66666666666") || this.cpf.equals("77777777777") ||
            this.cpf.equals("88888888888") || this.cpf.equals("99999999999") ||
            (this.cpf.length() != 11))
        {
            throw new CPFNotValidException();
        }
        return true;
    }
    
    public Vector<Hotel> load_user_hotels() throws SQLException
    {
        MetodosAcesso mtd = new MetodosAcesso();
        Vector<Hotel> v = new Vector<Hotel>();
        return v = mtd.load_user_hotels(this.getUser_id());
    }
}
