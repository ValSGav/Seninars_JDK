package seminar2.homeWork;

public class Client {

    private final Server server;

    private String name;

    ClientView view;

    public Client(Server server, ClientView view) {
        this.server = server;
        this.view = view;
    }
    public String getName() {
        return this.name;
    }

    public void acceptMessage(String message) {
        view.showMessage(message);
    }

    public void connectToServer(String name) {
        //загрузить историю сообщений

        if (!server.isEnable()) throw new ChatException("Сервер не доступен!");
        this.name = name;

        server.connectClient(this);
        //установить признак соединения
        view.connectToServer();
    }

    public void sendMessageToServer(String text) {
        server.sendMessage(text, this);
    }

    public void disconnectFromServer() {
        view.disconnectFromServer();
    }

    public void sendServerCommandDisconnect() {
        server.disconnectClient(this);
    }

    public void showMessage(String message) {
        view.showMessage(message);
    }
}
