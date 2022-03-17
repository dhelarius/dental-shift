
package com.project.dentalshift.dao;

import com.project.dentalshift.factory.db.DBAdapterFactory;
import com.project.dentalshift.factory.db.IDBAdapter;
import com.project.dentalshift.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductDAO {
    
    private final IDBAdapter adapter;
    
    public ProductDAO(){
        adapter = DBAdapterFactory.getAdapter();
    }
    
    public void saveProduct(Product product){
        
       try {
         String sql = "insert into t_productos values(?, ?, ?)";
         Connection connection = adapter.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setLong(1, product.getId());
         statement.setString(2, product.getName());
         statement.setDouble(3, product.getPrice());
         statement.executeUpdate();
       } catch(Exception e) {
         e.printStackTrace();
       }
    }
    
    public List<Product> getAllProducts() {
        try {
            String sql = "select * from t_productos";
            Connection connection = adapter.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            
            List<Product> products = new ArrayList<>();
            
            while(results.next()) {
                Long id = results.getLong(1);
                String name = results.getString(2);
                Double price = results.getDouble(3);
                Product current = new Product(id, name, price);
                products.add(current);
            }
            
            return products;

        } catch(Exception e) {
          e.printStackTrace();
          return null;
        }        
    }
}
