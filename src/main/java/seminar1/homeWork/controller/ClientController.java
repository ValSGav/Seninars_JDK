package seminar1.homeWork.controller;


import seminar1.homeWork.model.Commands;
import seminar1.homeWork.model.exception.ConnectException;
import seminar1.homeWork.view.ClientWindow;
import seminar1.homeWork.model.Server;
import seminar1.homeWork.model.Client;

public class ClientController {
    ClientWindow clientWindow;
    Client client;

    public ClientController(String clientWindowName, Server server , int leftPoint) {
        this.clientWindow = new ClientWindow(clientWindowName, this, leftPoint);
        this.client = new Client(server, this);
    }

    public void deliverTheMessage(Commands command, String text) throws ConnectException {
        switch (command) {
            case SEND_CONNECT_TO_SERVER -> this.client.connectToServer(text);
            case ADD_TEXT_TO_CLIENT -> this.clientWindow.appendMessage(text);
            case SEND_TEXT_TO_SERVER -> this.client.sendMessageToServer(text);
            case ACCEPT_DISCONNECT_FROM_SERVER -> {
                this.clientWindow.appendMessage("Server disconnected.");
                this.clientWindow.setStateDisconnectFromServer();
            }
            case SEND_DISCONNECT_TO_SERVER -> this.client.sendServerCommandDisconnect();
        }
    }

    public void run(){
        this.clientWindow.setVisible(true);
    }
}
