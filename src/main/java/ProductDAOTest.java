import dao.ProductDAO;
import model.Product;

public class ProductDAOTest {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        Product testProduct = new Product();
        testProduct.setName("Gaming Mouse");
        testProduct.setStatus("pending");
        testProduct.setQrCode("mouseYZ"); // This will be encoded
        testProduct.setPrice(49.99);

        dao.insertProduct(testProduct);

        System.out.println("Inserted and QR code should be generated!");
    }
}
