package seminar2.homeWork;

import seminar2.homeWork.impl.FileRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Server {
    ServerView view;
    private final ArrayList<Client> connectedClients;
    private String messageHistory;
    private boolean enable;
    private final String fileName;

    private final Repository repository;

    public void setView(ServerView view) {
        this.view = view;
    }

    public Server() {
        this.connectedClients = new ArrayList<>();
        this.messageHistory = "";
        this.fileName = "src/main/java/seminar2/homeWork/messages.txt";
        this.repository = new FileRepository(fileName);
        this.messageHistory = repository.getMessageHistory();

        this.enable = false;

    }

    public boolean isEnable() {
        return enable;
    }

    public void sendMessage(String text, Client client) {
        String fullMessageText = client.getName() + " say: " + text + "\n";
        messageHistory = messageHistory.concat(fullMessageText);
        sendMessageFromServerToAllClients(fullMessageText);
        view.showMessage(fullMessageText);
    }
    private void sendMessageFromServerToAllClients(String message) {
        for (Client connectedClient : connectedClients) {
            connectedClient.showMessage(message);
        }
    }
    public void changeStatus() {
        if (this.enable) {
            for (Client connectedClient : connectedClients)
                connectedClient.disconnectFromServer();
            connectedClients.clear();
            this.enable = false;
            view.setStatus(false);
        } else {
            this.enable = true;
            view.setStatus(true);
        }
    }

    public void saveMessageHistory() {
        repository.saveMessageHistory(messageHistory);
    }

    /**
     * @param client
     * метод вызывается с клиента, если он отключается сам
     */
    public void disconnectClient(Client client) {
        if (connectedClients.contains(client))
            connectedClients.remove(client);
        else throw new ChatException("Попытка отключиться от сервера неудачна! Клиент уже отключен от сервера.");
    }

    public void connectClient(Client client){
        if (connectedClients.contains(client))
            throw new ChatException("Попытка соединиться с сервером неудачна! Сервер отклонил соединение. Клиент уже был подключен.");
        connectedClients.add(client);
        client.showMessage(this.messageHistory);
        client.acceptMessage("Вы подключены к серверу.");
    }

    public void closeServer() {
        saveMessageHistory();
    }
}
