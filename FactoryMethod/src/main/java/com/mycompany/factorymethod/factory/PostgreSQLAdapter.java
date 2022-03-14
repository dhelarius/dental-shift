/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class PostgreSQLAdapter implements IDBAdapter {
    
    static{
        try{
           new org.postgresql.Driver();
        }catch(Exception e){}
    }

    @Override
    public Connection getConnection() {
        try
        {
            String connectionString = getConnectionString();
            String user = "postgres";
            String password = "12345";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        }catch(Exception e){
          e.printStackTrace();
          return null;
        }
    }
    
    private String getConnectionString(){
        return "jdbc:postgresql://localhost:5432/patterns";
    }
    
}
