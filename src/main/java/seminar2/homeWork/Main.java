package seminar2.homeWork;

import seminar2.homeWork.impl.ClientViewWindow;
import seminar2.homeWork.impl.ServerViewWindow;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();

        ServerViewWindow wnd_3 = new ServerViewWindow("Server window", server, 400);

        ClientViewWindow wnd_1 = new ClientViewWindow("Client 1", server, wnd_3.getLeftPoint() + ServerViewWindow.WINDOW_WIDTH +5);
        ClientViewWindow wnd_2 = new ClientViewWindow("Client 2", server, wnd_3.getLeftPoint() - ClientViewWindow.WINDOW_WIDTH -5);

        wnd_3.run();
        wnd_1.run();
        wnd_2.run();
    }
}
