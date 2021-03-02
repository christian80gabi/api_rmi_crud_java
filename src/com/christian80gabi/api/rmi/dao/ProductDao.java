// by Christian80gabi
package com.christian80gabi.api.rmi.dao;

import com.christian80gabi.api.rmi.database.ConnectionSingleton;
import com.christian80gabi.api.rmi.models.Product;
import com.christian80gabi.api.rmi.services.ProductServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductServices {

    static Connection getConnection() {
        System.out.println("MySQL Database connection...");
        return ConnectionSingleton.getConnection();
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("Adding a product referenced by: " + product.getReference());
        Connection conn = getConnection();
        String sql = "INSERT INTO products (reference, name, price, quantity) VALUE (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getReference());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Operation finished...");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public Product getProduct(String reference) {
        System.out.println("Looking for a product referenced by: " + reference);
        Connection conn = getConnection();
        Product product = null;
        String sql = "SELECT * FROM products WHERE reference = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, reference);

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                if (rs.next()) {
                    product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setReference(rs.getString("reference"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setQuantity(rs.getInt("quantity"));
                }
            }

            stmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if (product == null) throw new RuntimeException("No Product found");

        return product;
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("Getting the list of products...");
        Connection conn = getConnection();
        List<Product> products = null;
        String sql = "SELECT * FROM products";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                products = new ArrayList<>();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setReference(rs.getString("reference"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setQuantity(rs.getInt("quantity"));
                    products.add(product);
                }
            }

            stmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if (product == null) throw new RuntimeException("No Product found");

        return products;
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("Updating the product referenced by: " + product.getReference());
        Connection conn = getConnection();
        String sql ="UPDATE products SET name = ?, price = ?, quantity = ? WHERE reference = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getReference());

            stmt.executeUpdate();

            stmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(String reference) {
        System.out.println("Deleting the product referenced by: " + reference);
        Connection conn = getConnection();
        String sql = "DELETE FROM products WHERE reference = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, reference);

            stmt.executeUpdate();

            stmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
