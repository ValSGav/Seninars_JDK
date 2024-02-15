package seminar1.homeWork.view;

import seminar1.homeWork.controller.ServerController;
import seminar1.homeWork.model.Commands;
import seminar1.homeWork.model.exception.ConnectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ServerWindow extends JFrame {
    public static final int WINDOW_WIDTH = 200;
    public static final int WINDOW_HEIGHT = 200;
    private final ServerController serverController;
    private final JTextArea messages;
    private final JButton btnEnable;

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            serverController.deliverTheMessage(Commands.CLOSE_SERVER, "");
        }
        super.processWindowEvent(e);
    }

    public ServerWindow(String title, ServerController serverController, int leftPoint) throws HeadlessException {
        super(title);
        this.serverController = serverController;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(title);
        setResizable(false);

        btnEnable = new JButton();
        btnEnable.setText("Disable");

        btnEnable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverController.deliverTheMessage(Commands.SEND_CHANGE_STATUS, "");
                    if(btnEnable.getText().equals("Disable"))
                        btnEnable.setText("Enable");
                    else btnEnable.setText("Disable");
                } catch (ConnectException cE) {
                    messages.append(cE.getMessage());
                }
            }
        });

        messages = new JTextArea();
        messages.setEditable(false);
        messages.setAutoscrolls(true);
        JScrollPane sp = new JScrollPane(messages);
        add(sp, BorderLayout.CENTER);

        JComponent bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(btnEnable);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocation(leftPoint, getY());

    }


    public void updateMessages(String text) {
        this.messages.setText(text);
    }
}
