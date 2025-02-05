/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import field.PlayingField;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lenovo
 */
public interface RemoteServer extends Remote{
    PlayingField getField() throws RemoteException;
    int getClientId() throws RemoteException;
    PlayingField executeCommand(SerializableCommand command) throws RemoteException;
    boolean needToRepaint(int id) throws RemoteException;
    void setNtr(int id, boolean ntr) throws RemoteException;
}
