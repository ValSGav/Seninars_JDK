package seninar1.homeWork.view;

import seninar1.homeWork.controller.ServerController;
import seninar1.homeWork.model.Commands;
import seninar1.homeWork.model.ConnectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    public static final int WINDOW_WIDTH = 200;
    public static final int WINDOW_HEIGHT = 200;

    public ServerWindow(String title, ServerController serverController) throws HeadlessException {
        super(title);
        this.serverController = serverController;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(title);
        setResizable(false);

        btnEnable = new JButton();

        btnEnable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverController.deliverTheMessage(Commands.SEND_CHANGE_STATUS, "");
                } catch (ConnectException cE) {
                    messages.append(cE.getMessage());
                }
            }
        });

        add(messages, BorderLayout.CENTER);
        add(btnEnable, BorderLayout.SOUTH);


    }

    ServerController serverController;

    JTextArea messages;
    JButton btnEnable;

    public void setMessages(String text) {
        this.messages.setText(text);
    }

}
