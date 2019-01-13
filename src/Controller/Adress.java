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
public class Adress
{
    private String adress;
    private int city;
    private int state;
    private int country;
    private String adress_type;
    
    public boolean addAdress(Adress adress, String document) throws SQLException
    {
        MetodosAcesso mtd = new MetodosAcesso();
        if(mtd.addAdress(adress, document))
            return true;
        else
            return false;
    }
    
    public void manageAdress(Adress adress)
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
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
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
     * @return the adress_type
     */
    public String getAdress_type() {
        return adress_type;
    }

    /**
     * @param adress_type the adress_type to set
     */
    public void setAdress_type(String adress_type) {
        this.adress_type = adress_type;
    }
    
    public Vector<Adress> loadAdress(String adress_type, int id) throws SQLException
    {
        Vector<Adress> va = new Vector<Adress>();
        MetodosAcesso mtd = new MetodosAcesso();
        va = mtd.load_adress(id, adress_type);
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
