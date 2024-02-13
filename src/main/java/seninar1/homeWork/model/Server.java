package seninar1.homeWork.model;

import seninar1.homeWork.controller.ServerController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static seninar1.homeWork.model.Commands.UPDATE_MESSAGES;

public class Server {

    private final ArrayList<Client> connectedClients;
    private String messageHistory;
    private boolean enable;
    private ServerController serverController;

    private final String fileName;

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
        serverController.deliverTheMessage(UPDATE_MESSAGES, this.messageHistory);
    }

    public Server() throws ConnectException {
        this.connectedClients = new ArrayList<>();
        this.messageHistory = "";
        this.fileName = "./messages.txt";
        try (FileReader fr = new FileReader(fileName)) {
            int i;
            do {
                i = fr.read();
                this.messageHistory = this.messageHistory.concat(Character.toString((char) i));
            } while (i != -1);

        } catch (IOException e) {
            throw new ConnectException(e.getMessage());
        }

        this.enable = false;

    }


    public boolean isEnable() {
        return enable;
    }

    public void sendMessage(String text, Client client) {

        String fullMessageText = client.getName() + " say: " + text;

        //добавить сообщение в историю сообщений
        messageHistory = messageHistory.concat("\n").concat(fullMessageText);

        //разослать всем
        sendMessageFromServerToAll(fullMessageText);

        //показать в своем окошке
        if (serverController != null) {
            serverController.deliverTheMessage(UPDATE_MESSAGES, this.messageHistory);
        }


    }

    public void connect(Client client) throws ConnectException {
        if (connectedClients.contains(client))
            throw new ConnectException("Попытка соединиться с сервером неудачна! Сервер отклонил соединение. Клиент уже был подключен.");
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
        if (this.enable) {
            for (Client connectedClient : connectedClients)
                connectedClient.disconnectFromServer();
            connectedClients.clear();
            this.enable = false;
        } else {
            this.enable = true;
        }

    }

    public void saveMessageHistory() throws ConnectException{
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(this.messageHistory);
        } catch (IOException e) {
            throw new ConnectException(e.getMessage());
        }

    }

    public void disconnectClient(Client client) throws ConnectException{
        if (connectedClients.contains(client))
            connectedClients.remove(client);
        else throw new ConnectException("Попытка отключиться от сервера неудачна! Клиент уже отключен от сервера.");
    }
}
