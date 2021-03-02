// by Christian80gabi
package com.christian80gabi.api.rmi.models;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {
    // ATTRIBUTES
    /**
     * id INT NOT NULL AUTO_INCREMENT
     */
    private int id;
    /**
     * reference VARCHAR(32) NOT NULL
     */
    private String reference;
    /**
     * name VARCHAR(52) NOT NULL DEFAULT 'undefined"
     */
    private String name;
    /**
     * price double NOT NULL DEFAULT 0.0
     */
    private double price;
    /**
     * quantity INT NOT NULL DEFAULT 0
     */
    private int quantity;

    //CONSTRUCTORS
    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.reference = generateUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.reference = generateUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // PERSONALIZED METHODS

    /**
     * Autogenerate a Universally unique identifier (UUID)
     * remove all '-' from the generated string
     * @return a unique ID (String)
     */
    static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        uuid = uuid.toUpperCase();
        return uuid;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ToSTRING
    @Override
    public String toString() {
        return "Product{" +
                "reference:'" + reference + '\'' +
                ", name:'" + name + '\'' +
                ", price:" + price +
                ", quantity:" + quantity +
                '}';
    }
}
