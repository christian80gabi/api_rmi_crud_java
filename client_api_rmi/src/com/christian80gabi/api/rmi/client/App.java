package com.christian80gabi.api.rmi.client;

import com.christian80gabi.api.rmi.models.Product;
import com.christian80gabi.api.rmi.services.ProductServices;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class App {
    static int port = 1090;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // Connect to the API
        String uri = "rmi://localhost:"+port+"/api";
        System.out.println("Connected to => " + uri);
        ProductServices services = (ProductServices) Naming.lookup(uri);

        // Get a list of products from the API
        List<Product> products;
        products = services.getProducts();

        System.out.println("List of products...");
        for (Product p : products) {
            System.out.println(p);
        }

        // Create a product
        Product product;

        // Get from the database a specified product referenced by its reference
        System.out.println("\n\nType a product reference: ");
        String reference = scanner.next();

        // Sending the request to the server
        // Get a product from the API
        System.out.println("We'll look for it in our database for you...\n");
        product = services.getProduct(reference);

        System.out.println("And the answer is... Wait for it...\n");

        if (product != null && product.getReference() != null) {
            System.out.println("=> Product found :)");
            System.out.println("The product referenced by '" + reference + "' is: " + product);
        } else {
            System.out.println("=> No Product found :(");
        }
    }
}
