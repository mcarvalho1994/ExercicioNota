/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class MySQLConnection
{
    
    public static String status = "Não conectou...";
    public MySQLConnection()
    {
        
    }
    
    public static Connection getMySQLConnection() throws SQLException
    {
        Connection conn = null;
        
        try
        {
            String serverName = "localhost";
            String database = "guiahoteleiro";
            String url = "jdbc:mysql://" + serverName + "/" + database + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, username, password);
            
            if (conn != null) {
 
                status = ("STATUS--->Conectado com sucesso!\n");
 
            } else {
 
                status = ("STATUS--->Não foi possivel realizar conexão");
 
            }
            
            return conn;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar: " + e.getMessage());
            return null;
        }
    }
    
    public static String statusMySQLConection()
    {
        return status;
    }
}
