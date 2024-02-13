package seninar1.homeWork.controller;

import seninar1.homeWork.model.Commands;
import seninar1.homeWork.model.Server;
import seninar1.homeWork.view.ServerWindow;

import javax.swing.*;

public class ServerController {

    Server server;
    ServerWindow serverWindow;

    public void deliverTheMessage(Commands command, String s) {
        switch (command) {
            case SEND_CHANGE_STATUS: {
                server.changeStatus();
                break;
            }
        }
    }
}

