/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class SerializableCommand implements Serializable {
    public int playerIndex;
    public String commandName;
    public int iIndex, jIndex;
    public int status;

    public SerializableCommand() {
        playerIndex = -1;
        commandName = "";
        iIndex = -1;
        jIndex = -1;
        status = -1;
    }
    
    public SerializableCommand(int playerIndex, String commandName, int iIndex, int jIndex){
        this.playerIndex = playerIndex;
        this.commandName = commandName;
        this.iIndex = iIndex;
        this.jIndex = jIndex;
        status = 0;
    }
    
    public void setArgs(int playerIndex, String commandName, int iIndex, int jIndex) {
        this.playerIndex = playerIndex;
        this.commandName = commandName;
        this.iIndex = iIndex;
        this.jIndex = jIndex;
        status = 1;
    }
}
