// by Christian80gabi
package com.christian80gabi.api.rmi.services;

import com.christian80gabi.api.rmi.models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductServices extends Remote {
    public void addProduct(Product product) throws RemoteException;
    public Product getProduct(String reference) throws RemoteException;
    public List<Product> getProducts() throws RemoteException;
    public void updateProduct(Product product) throws RemoteException;
    public void deleteProduct(String reference) throws RemoteException;
}
