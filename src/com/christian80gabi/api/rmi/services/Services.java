// By christian80gabi
package com.christian80gabi.api.rmi.services;

import com.christian80gabi.api.rmi.dao.ProductDao;
import com.christian80gabi.api.rmi.models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Services extends UnicastRemoteObject {
    ProductServices service = new ProductDao();

    public Services() throws RemoteException {
        super();
    }

    public void addProduct(Product product) throws RemoteException {
        service.addProduct(product);
        System.out.println("Product added successfully!!!");
    }

    public Product getProduct(String reference) throws RemoteException {
       return service.getProduct(reference);
    }

    public List<Product> getProducts() throws RemoteException {
        return service.getProducts();
    }

    public void updateProduct(Product product) throws RemoteException {
        service.updateProduct(product);
        System.out.println("Product updated successfully!!!");
    }

    public void deleteProduct(String reference) throws RemoteException {
        service.deleteProduct(reference);
        System.out.println("Product deleted successfully!!!");
    }
}
