package seninar1.homeWork;

import seninar1.homeWork.controller.ClientController;
import seninar1.homeWork.controller.ServerController;
import seninar1.homeWork.model.Server;
import seninar1.homeWork.view.ClientWindow;
import seninar1.homeWork.view.ServerWindow;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();

        ServerController wnd_3 = new ServerController("Server", server, 400);

        ClientController wnd_1 = new ClientController("Client 1", server, wnd_3.getLeftPoint() + ServerWindow.WINDOW_WIDTH +5);
        ClientController wnd_2 = new ClientController("Client 2", server, wnd_3.getLeftPoint() - ClientWindow.WINDOW_WIDTH -5);

        wnd_3.run();
        wnd_1.run();
        wnd_2.run();
    }
}
