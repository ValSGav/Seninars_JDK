package seninar1.homeWork.model;

import seninar1.homeWork.controller.ClientController;

import java.util.ArrayList;

public class Server {

    private ArrayList<Client> connectedClients;

    private boolean enable;
    private ClientController clientController;

    public boolean isEnable() {
        return enable;
    }

    public void sendMessage(String text, Client client) {
        String fullMessageText = client.getName() + " say: " + text;

        //добавить сообщение в историю сообщений

        //разослать всем
        sendMessageFromServerToAll(fullMessageText);


        //показать в своем окошке
    }

    public void connect(Client client) throws ConnectException {
        if (connectedClients.contains(client))
            throw new ConnectException("Сервер отклонил соединение. Клиент уже был подключен.");
    }

    private void sendMessageFromServerToAll(String fullMessageText) {
        for (Client connectedClient : connectedClients) {
            connectedClient.acceptMessage(fullMessageText);
        }
    }
}
