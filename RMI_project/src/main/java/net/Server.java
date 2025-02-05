/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import field.PlayingField;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Server implements RemoteServer {
    
    public static String name = "RMIServer";
    public static final int port=8080;
    static PlayingField pfield;
    static Queue<Integer> clientIds;
    static boolean ntr1, ntr2;
    
    public Server(){
        pfield = new PlayingField(6, 6);
        clientIds = new LinkedList<Integer>();
        clientIds.add(1);
        clientIds.add(2);
        ntr1 = false;
        ntr2 = false;
    }
    
    @Override
    public PlayingField getField() throws RemoteException {
        return pfield;
    }
    
    @Override
    public int getClientId() throws RemoteException {
        return clientIds.remove();
    }
    
    @Override
    public boolean needToRepaint(int id) {
        if (id == 1) {
            return ntr2;
        } else {
            return ntr1;
        }
    }
    
    @Override
    public void setNtr(int id, boolean ntr) {
        if (id == 1){
            ntr1 = ntr;
        } else {
            ntr2 = ntr;
        }
    }
    
    @Override
    public PlayingField executeCommand(SerializableCommand command) throws RemoteException {
        if (command.playerIndex == 1) {
            if (command.commandName.equals("ChooseHLine")){
                pfield.setHlineState(command.iIndex, command.jIndex, "RED");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (command.commandName.equals("ChooseVLine")){
                pfield.setVlineState(command.iIndex, command.jIndex, "RED");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (command.commandName.equals("SetSymbol")) {
                pfield.setCellState(command.iIndex, command.jIndex, "A");
                pfield.countScore();
            }
        }
        if (command.playerIndex == 2) {
            if (command.commandName.equals("ChooseHLine")){
                pfield.setHlineState(command.iIndex, command.jIndex, "GREEN");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (command.commandName.equals("ChooseVLine")){
                pfield.setVlineState(command.iIndex, command.jIndex, "GREEN");
                if (!pfield.needToSetSymbol()){
                    pfield.whoMove = pfield.switchMove();
                }
            }
            if (command.commandName.equals("SetSymbol")) {
                pfield.setCellState(command.iIndex, command.jIndex, "B");
                pfield.countScore();
            }
        }
        return pfield;
    }

    public static void main(String args[]) throws Exception{
        Registry registry= LocateRegistry.createRegistry(port);
        Server server = new Server();
        Remote proxy = UnicastRemoteObject.exportObject(server, port);
        System.out.println("proxy = " + proxy);
        registry.rebind(name, proxy);
    }   

}
