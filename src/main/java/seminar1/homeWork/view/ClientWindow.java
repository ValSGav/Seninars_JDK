package seminar1.homeWork.view;

import seminar1.homeWork.model.exception.ConnectException;
import seminar1.homeWork.controller.ClientController;
import seminar1.homeWork.model.Commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientWindow extends JFrame {

    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 300;


    private final ClientController clientController;
    private final JTextArea messages;
    private JTextField login;
    private JTextField message;
    private JPanel northPanel;
    private JComponent southPanel;

    public ClientWindow(String title, ClientController clientController, int leftPoint) throws HeadlessException {

        this.clientController = clientController;

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

        southPanel.setVisible(false);
        northPanel.setVisible(true);

    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            clientController.deliverTheMessage(Commands.SEND_DISCONNECT_TO_SERVER, "");
        }
        super.processWindowEvent(e);
    }

    private void prepareSouthPanel() {

        southPanel = new JPanel(new GridLayout(1, 2));

        JButton btnSend = new JButton();
        btnSend.setText("Send");
        btnSend.addActionListener(e -> {
            try {
                clientController.deliverTheMessage(Commands.SEND_TEXT_TO_SERVER, message.getText());
            } catch (ConnectException cE) {
                messages.append("\n" + cE.getMessage());
            }
        });

        class KeyTypedListener extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    try {
                        clientController.deliverTheMessage(Commands.SEND_TEXT_TO_SERVER, message.getText());
                    } catch (ConnectException cE) {
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
                clientController.deliverTheMessage(Commands.SEND_CONNECT_TO_SERVER, login.getText());
                southPanel.setVisible(true);
                northPanel.setVisible(false);
            } catch (ConnectException cE) {
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

    public void appendMessage(String text) {
        this.messages.append("\n" + text);
    }

    public void setStateDisconnectFromServer() {
        southPanel.setVisible(false);
        northPanel.setVisible(true);
    }
}
