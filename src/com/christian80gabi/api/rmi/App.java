package com.christian80gabi.api.rmi;

import com.christian80gabi.api.rmi.services.Services;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * RMI Server
 */
public class App {
    static int port = 1090;
    public static void main(String[] args) throws Exception {
        // Service Object
        Services service = new Services();

        // Naming Service
        LocateRegistry.createRegistry(port);

        // Bind services names
        String uri = "rmi://localhost:"+port+"/api";
        Naming.rebind(uri, service);

        System.out.println(uri + " <=> " + service);
    }
}
