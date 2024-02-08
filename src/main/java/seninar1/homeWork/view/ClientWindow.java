package seninar1.homeWork.view;

import seninar1.homeWork.model.client.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClientWindow extends JFrame {

    private boolean isConnectedToServer;
    private ArrayList<String> messages;

    private boolean sendMessage(String text){
        if (isConnectedToServer){

        };
        return false;
    };

    public boolean acceptMessage(){
       return false;
    };

    private boolean connectToServer(){
        //загрузить историю сообщений
        //установить признак соединения
        return false;
    };

    public ClientWindow(String title) throws HeadlessException {
        super(title);
    }

}
