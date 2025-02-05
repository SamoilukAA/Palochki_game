package net;

public class SerializableCommand {
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
