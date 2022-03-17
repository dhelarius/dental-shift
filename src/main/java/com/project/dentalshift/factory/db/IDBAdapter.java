
package com.project.dentalshift.factory.db;

import java.sql.Connection;

/**
 *
 * @author HP
 */
public interface IDBAdapter {
    public Connection getConnection();
}
