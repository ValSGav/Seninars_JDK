package seninar1.homeWork;

import seninar1.homeWork.controller.ClientController;
import seninar1.homeWork.model.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        ClientController wnd_1 = new ClientController("Client 1", server);
        ClientController wnd_2 = new ClientController("Client 2", server);

    }
}
