
package com.mycompany.factorymethod.factory;

import java.sql.Connection;

/**
 *
 * @author HP
 */
public interface IDBAdapter {
    public Connection getConnection();
}
