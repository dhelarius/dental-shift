
import com.project.dentalshift.dao.ProductDAO;
import com.project.dentalshift.entities.Product;
import java.util.List;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(3L, "Producto 3", 30);
        
        ProductDAO dao = new ProductDAO();
        //dao.saveProduct(product1);
        
        List<Product> allProducts = dao.getAllProducts();
        
        for(Product current: allProducts) {
            System.out.println(current.toString());
        }
    }        
}
