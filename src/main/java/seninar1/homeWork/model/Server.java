package seninar1.homeWork.model;

import seninar1.homeWork.controller.ClientController;

import java.util.ArrayList;

import static seninar1.homeWork.model.Commands.ACCEPT_DISCONNECT_FROM_SERVER;

public class Server {

    private ArrayList<Client> connectedClients;
    private String messageHistory;

    private boolean enable;
    private ClientController clientController;

    public boolean isEnable() {
        return enable;
    }

    public void sendMessage(String text, Client client) {
        String fullMessageText = client.getName() + " say: " + text;

        //добавить сообщение в историю сообщений
        messageHistory = messageHistory.concat("/n").concat(fullMessageText);

        //разослать всем
        sendMessageFromServerToAll(fullMessageText);

        //показать в своем окошке

    }

    public void connect(Client client) throws ConnectException {
        if (connectedClients.contains(client))
            throw new ConnectException("Сервер отклонил соединение. Клиент уже был подключен.");
        connectedClients.add(client);
        client.acceptMessage(this.messageHistory);
        client.acceptMessage("Вы подключены к серверу.");
    }

    private void sendMessageFromServerToAll(String fullMessageText) {
        for (Client connectedClient : connectedClients) {
            connectedClient.acceptMessage(fullMessageText);
        }
    }

    public void changeStatus() {
        if (this.enable){
            for (Client connectedClient : connectedClients) {
                connectedClient.disconnectFromServer();
            };

            connectedClients.clear();



        }else {};
    }
}
