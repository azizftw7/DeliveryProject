package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import model.Product;
import util.DBConnection;
import util.QRCodeGenerator;
public class ProductDAO {

	public void insertProduct(Product product) {
	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String qrCodeText = product.getName().replaceAll("[^a-zA-Z0-9]", "_") + "-" + timestamp;
	    String filePath = "/webapp/qr-codes/" + qrCodeText + ".png";

	    try {
	       
	        QRCodeGenerator.generateQRCodeImage(qrCodeText, 250, 250, filePath);
	        System.out.println("QR Code image created: " + filePath);

	        // Set the code into the product before inserting
	        product.setQrCode(qrCodeText);

	        // Insert product into DB
	        String query = "INSERT INTO products (name, status, code, price) VALUES (?, ?, ?, ?)";
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setString(1, product.getName());
	            statement.setString(2, product.getStatus());
	            statement.setString(3, product.getQrCode()); // this is the text
	            statement.setDouble(4, product.getPrice());

	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Inserted product: " + product.getName());
	            }
	        }

	    } catch (Exception e) {
	        System.err.println("Error inserting product or generating QR code: " + e.getMessage());
	        e.printStackTrace();
	    }
	}



    public Product getProductByQRCode(String qrCode) {
        Product product = null;

        String query = "SELECT * FROM products WHERE code = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, qrCode);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setStatus(rs.getString("status"));
                product.setQrCode(rs.getString("code"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        
        String query = "SELECT * FROM products"; 
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()
            		 ) {
        	
        	

            
        	while (resultSet.next()) {
        	 

        	    Product product = new Product();
        	    product.setId(resultSet.getInt("id"));
        	    product.setName(resultSet.getString("name"));
        	    product.setStatus(resultSet.getString("status"));
        	    product.setQrCode(resultSet.getString("code")); 
        	    product.setPrice(resultSet.getDouble("price"));

        	  

        	    productList.add(product);
        	}
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return productList;
    }
    public boolean updateProduct(Product product) {
        String query = "UPDATE products SET name = ?, status = ?, Code = ?, price = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, product.getName());
            statement.setString(2, product.getStatus());
            statement.setString(3, product.getQrCode());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getId());
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM products WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, productId);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}
