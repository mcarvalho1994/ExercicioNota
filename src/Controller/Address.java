/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MetodosAcesso;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Marcos
 */
public class Address
{
    private String address;
    private int city;
    private int state;
    private int country;
    private String address_type;
    
    public boolean addAddress(Address address, String document) throws SQLException
    {
        MetodosAcesso mtd = new MetodosAcesso();
        if(mtd.addAddress(address, document))
            return true;
        else
            return false;
    }
    
    public void manageAddress(Address address)
    {
        
    }
    
    public Vector<ComboMultiData> list(String type) throws SQLException
    {
        Vector <ComboMultiData> v = new Vector();
        MetodosAcesso dao = new MetodosAcesso();
        
        v = dao.list(type);
        
        return v;
    }
    
    public Vector<ComboMultiData> list(String type, int index) throws SQLException
    {
        Vector <ComboMultiData> v = new Vector();
        MetodosAcesso dao = new MetodosAcesso();
        
        v = dao.list(type, index);
        
        return v;
    }  

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public int getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(int city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * @return the address_type
     */
    public String getAddress_type() {
        return address_type;
    }

    /**
     * @param address_type the address_type to set
     */
    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }
    
    public Vector<Address> loadAddress(String address_type, int id) throws SQLException
    {
        Vector<Address> va = new Vector<Address>();
        MetodosAcesso mtd = new MetodosAcesso();
        va = mtd.load_address(id, address_type);
        return va;
    }
    
    public int getCityIndex(int state_id, int city_id) throws SQLException
    {
        int index = 0;
        MetodosAcesso mtd = new MetodosAcesso();
        index = mtd.getCityIndex(state_id, city_id);
        return index;
    }
    
}
