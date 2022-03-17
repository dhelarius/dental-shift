
package com.project.dentalshift.factory.db;

import com.project.dentalshift.factory.db.types.DBType;
import com.project.dentalshift.utils.PropertyUtil;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author HP
 */
public class DBAdapterFactory {
    
    private static final String DB_TYPE = "dbadaptertype"; 
    
    public static IDBAdapter getAdapter(DBType type) {
        switch(type) {
                case POSTGRESQL:
                    return new PostgreSQLAdapter();
                case MYSQL:
                    return new MySQLAdapter();
                default:
                    return null;
        }
    }
    
    public static IDBAdapter getAdapter(){
        try {
            Properties p = PropertyUtil.load();

            assert p != null;
            String dbtype = p.getProperty(DB_TYPE);

            return (IDBAdapter)Class.forName(dbtype).getDeclaredConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static Properties loadProperties() {
        try {
            Properties p = new Properties();
            InputStream stream = 
                    DBAdapterFactory.class.getClassLoader().getResourceAsStream("META-INF/dbadapter.properties");
            p.load(stream);
            return p;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
