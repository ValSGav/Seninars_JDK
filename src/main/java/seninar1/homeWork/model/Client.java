package seninar1.homeWork.model;

import seninar1.homeWork.controller.ClientController;

public class Client {
    private boolean isConnected;
    private Server server;

    public Client(Server server, ClientController clientController) {
        this.server = server;
        this.clientController = clientController;
    }

    private ClientController clientController;
    private String name;

    public String getName() {
        return this.name;
    }

    private void sendMessage(String text) throws ConnectException {
        if (isConnected && server.isEnable()) {
            server.sendMessage(text, this);
        } else throw new ConnectException("Сервер не доступен!");

    }

    public void acceptMessage(String text) {
        clientController.deliverTheMessage(Commands.ADD_TEXT_TO_CLIENT, text);
    }

    public void connectToServer(String name) throws ConnectException {
        //загрузить историю сообщений


        if (!server.isEnable()) throw new ConnectException("Сервер не доступен!");
        this.name = name;

        server.connect(this);
        //установить признак соединения
    }

}
