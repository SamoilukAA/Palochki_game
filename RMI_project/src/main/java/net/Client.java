/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import field.PaintField;
import field.PlayingField;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Client {
    static String host = "localhost";
    static int port = 8080; 
    static String name = "RMIServer";
    
    static int id;
    static SerializableCommand command;
    static PlayingField pfield;
    static PaintField pf;
    static boolean ntr;
    
    static Thread changeFild, fieldIsChanged;
    
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(host, port);
        RemoteServer proxy = (RemoteServer)registry.lookup(name);
        System.out.println("proxy = " + proxy);
        ntr = false;
        id = proxy.getClientId();
        System.out.println(id);        
        pfield = proxy.getField();
        command = new SerializableCommand();
        pf = new PaintField(id, pfield, command);
        
        changeFild = new Thread(
                ()-> {
                    while (true) {
                        command = pf.getCommand();
                        if (command.status == 1){
                            try {
                                pfield = proxy.executeCommand(command);
                                command.status = 0;
                            } catch (RemoteException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ntr = true;
                            try {
                                proxy.setNtr(id, ntr);
                            } catch (RemoteException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            pf.repaintField(pfield);
                        }
                    }
                }
        );
        changeFild.start();
        
        fieldIsChanged = new Thread(
                ()-> {
                    while (true) {
                        try {
                            ntr = proxy.needToRepaint(id);
                        } catch (RemoteException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (ntr){
                            try {
                                pfield = proxy.getField();
                            } catch (RemoteException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            pf.repaintField(pfield);
                            ntr = false;
                            try {
                                if (id == 1) {
                                    proxy.setNtr(2, ntr);
                                } else {
                                    proxy.setNtr(1, ntr);
                                }
                            } catch (RemoteException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
        );
        fieldIsChanged.start();
    }
}
