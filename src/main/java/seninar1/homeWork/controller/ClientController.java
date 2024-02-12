package seninar1.homeWork.controller;


import seninar1.homeWork.model.Commands;
import seninar1.homeWork.model.ConnectException;
import seninar1.homeWork.model.Server;
import seninar1.homeWork.view.ClientWindow;
import seninar1.homeWork.model.Client;

public class ClientController {
    ClientWindow clientWindow;
    Client client;

    public ClientController(String clientWindowName, Server server) {
        this.clientWindow = new ClientWindow(clientWindowName, this);
        this.client = new Client(server, this);
    }

    public void deliverTheMessage(Commands command, String text) throws ConnectException{
        switch (command) {
            case SEND_CONNECT_TO_SERVER: {
                this.client.connectToServer(text);
                break;
            }
            case ADD_TEXT_TO_CLIENT:{
                this.clientWindow.appendMessage(text);
                break;
            }
        }
    }


}
