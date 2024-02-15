package seminar1.homeWork.controller;

import seminar1.homeWork.model.Commands;
import seminar1.homeWork.model.Server;
import seminar1.homeWork.view.ServerWindow;


public class ServerController {

    Server server;
    ServerWindow serverWindow;

    public ServerController(String serverWidowName, Server server, int leftPoint) {
        this.server = server;
        serverWindow = new ServerWindow(serverWidowName, this, leftPoint);
        server.setServerController(this);
    }

    public void deliverTheMessage(Commands command, String text) {
        switch (command) {
            case SEND_CHANGE_STATUS -> server.changeStatus();
            case UPDATE_MESSAGES -> serverWindow.updateMessages(text);
            case CLOSE_SERVER -> server.saveMessageHistory();
        }
    }

    public int getLeftPoint(){
        return this.serverWindow.getX();
    }

    public void run(){
        this.serverWindow.setVisible(true);
    }
}

