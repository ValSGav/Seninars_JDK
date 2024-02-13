package seninar1.homeWork.view;

import seninar1.homeWork.controller.ClientController;
import seninar1.homeWork.model.Commands;
import seninar1.homeWork.model.ConnectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ClientWindow extends JFrame {

    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 300;


    ClientController clientController;
    JTextArea messages;
    JTextField ip, port, login, message;
    JPasswordField password;
    JButton btnConnect, btnSend;
    JPanel connectPanel;

    public ClientWindow(String title, ClientController clientController) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(title);
        setResizable(false);

        ip = new JTextField();
        port = new JTextField();
        login = new JTextField();
        password = new JPasswordField();
        message = new JTextField();

        btnConnect = new JButton();
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clientController.deliverTheMessage(Commands.SEND_CONNECT_TO_SERVER, login.getText());
                } catch (ConnectException cE) {
                    messages.append(cE.getMessage());
                }
            }
        });

        connectPanel = new JPanel(new GridLayout(2, 3));
        connectPanel.add(ip);
        connectPanel.add(port);
        connectPanel.add(new JLabel());
        connectPanel.add(login);
        connectPanel.add(password);
        connectPanel.add(btnConnect);

        add(connectPanel, BorderLayout.NORTH);

        messages = new JTextArea();
        messages.setEditable(false);
        add(messages);

        JComponent bottomPanel = new JPanel(new GridLayout(1, 2));
        btnSend = new JButton();
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clientController.deliverTheMessage(Commands.SEND_TEXT_TO_SERVER, message.getText());
                } catch (ConnectException cE) {
                    messages.append(cE.getMessage());
                }
            }
        });
        bottomPanel.add(message);
        bottomPanel.add(btnSend);
        add(bottomPanel, BorderLayout.SOUTH);

        bottomPanel.setVisible(false);

        setVisible(true);
    }


    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            //disconnectFromServer();
        }
        super.processWindowEvent(e);
    }

    public void appendMessage(String text) {
        this.messages.append(text);
    }

}
