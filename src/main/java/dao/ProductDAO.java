package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Product;
import util.DBConnection;

public class ProductDAO {

    public void insertProduct(Product product) {
        String sql = "INSERT INTO products (name, status, qrCode) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getStatus());
            stmt.setString(3, product.getQrCode());

            stmt.executeUpdate();
            System.out.println("Product inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
