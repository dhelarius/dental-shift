/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dentalshift.factory.db;

import com.project.dentalshift.utils.PropertyUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @author HP
 */
public class PostgreSQLAdapter implements IDBAdapter {
    
    static {
        try {
           new org.postgresql.Driver();
        } catch(Exception e) {}
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = getConnectionString();

            Properties p = PropertyUtil.load();
            assert p != null;
            String user = p.getProperty(PropertyUtil.USER);
            String password = p.getProperty(PropertyUtil.PASSWORD);

            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch(Exception e) {
          e.printStackTrace();
          return null;
        }
    }
    
    private String getConnectionString(){
        return Objects.requireNonNull(PropertyUtil.load()).getProperty(PropertyUtil.CONNECTION);
    }
    
}
