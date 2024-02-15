package seminar2.homeWork.impl;


import seminar2.homeWork.ChatException;
import seminar2.homeWork.Client;
import seminar2.homeWork.ClientView;
import seminar2.homeWork.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ClientViewWindow extends JFrame implements ClientView {
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 300;

    Client client;


    private final JTextArea messages;
    private JTextField login;
    private JTextField message;
    private JPanel northPanel;
    private JComponent southPanel;

    public ClientViewWindow(String title
            , Server server
            , int leftPoint) throws HeadlessException {

        this.client = new Client(server, this);

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(leftPoint, getY());
        setTitle(title);
        setResizable(false);

        prepareNorthPanel();
        prepareSouthPanel();

        add(northPanel, BorderLayout.NORTH);

        messages = new JTextArea();
        messages.setEditable(false);
        messages.setAutoscrolls(true);
        JScrollPane sp = new JScrollPane(messages);
        add(sp, BorderLayout.CENTER);

        add(southPanel, BorderLayout.SOUTH);

        disconnectFromServer();

    }

    @Override
    public void showMessage(String message) {
        this.messages.append(message);
    }

    @Override
    public void connectToServer() {
        southPanel.setVisible(true);
        northPanel.setVisible(false);
    }

    @Override
    public void disconnectFromServer() {
        southPanel.setVisible(false);
        northPanel.setVisible(true);
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            client.sendServerCommandDisconnect();
        }
        super.processWindowEvent(e);
    }

    private void prepareSouthPanel() {

        southPanel = new JPanel(new GridLayout(1, 2));

        JButton btnSend = new JButton();
        btnSend.setText("Send");
        btnSend.addActionListener(e -> {
            try {
                client.sendMessageToServer(message.getText());
            } catch (ChatException cE) {
                messages.append("\n" + cE.getMessage());
            }
        });

        class KeyTypedListener extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    try {
                        client.sendMessageToServer(message.getText());
                    } catch (ChatException cE) {
                        messages.append("\n" + cE.getMessage());
                    }
                }
            }
        }
        message.addKeyListener(new KeyTypedListener());



        southPanel.add(message);
        southPanel.add(btnSend);
    }

    private void prepareNorthPanel() {

        JTextField ip = new JTextField();
        JTextField port = new JTextField();
        login = new JTextField();
        JPasswordField password = new JPasswordField();
        message = new JTextField();

        northPanel = new JPanel(new GridLayout(2, 3));

        JButton btnConnect = new JButton();
        btnConnect.setText("Send");
        btnConnect.addActionListener(e -> {
            try {
                client.connectToServer(login.getText());
                southPanel.setVisible(true);
                northPanel.setVisible(false);
            } catch (ChatException cE) {
                messages.append("\n" + cE.getMessage());
            }
        });

        northPanel.add(ip);
        northPanel.add(port);
        northPanel.add(new JLabel());
        northPanel.add(login);
        northPanel.add(password);
        northPanel.add(btnConnect);

    }

    public void run(){
        this.setVisible(true);
    }
}
