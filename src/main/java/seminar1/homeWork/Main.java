package seminar1.homeWork;

import seminar1.homeWork.view.ClientWindow;
import seminar1.homeWork.view.ServerWindow;
import seminar1.homeWork.controller.ClientController;
import seminar1.homeWork.controller.ServerController;
import seminar1.homeWork.model.Server;

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
