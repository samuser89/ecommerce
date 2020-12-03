/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.ecommerce.service;
import java.sql.*;

/**
 *
 * @author EliteBook
 */
public class ConnectionDB {
    private static Connection cnx = null;
    
    public static Connection GetConnection() throws SQLException, ClassNotFoundException{
        if(cnx == null){
            try{
            
               String server, dataBase, user, password = "";
               
               server = "localhost";
               dataBase = "Ecommerce";
               user = "UserEcommerce";
               password = "123456";
               
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               cnx = DriverManager.getConnection("jdbc:sqlserver://" + server + ":1433; databaseName=" + dataBase,
                       user,
                       password);
                
            }catch(Exception ex){
                throw ex;
            }
        }
        
        return cnx;
    }
}
