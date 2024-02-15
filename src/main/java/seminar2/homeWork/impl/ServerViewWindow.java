package seminar2.homeWork.impl;

import seminar1.homeWork.controller.ServerController;
import seminar1.homeWork.model.Commands;
import seminar1.homeWork.model.exception.ConnectException;
import seminar2.homeWork.Server;
import seminar2.homeWork.ServerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ServerViewWindow extends JFrame implements ServerView  {

    public static final int WINDOW_WIDTH = 200;
    public static final int WINDOW_HEIGHT = 200;
    private final Server server;
    private final JTextArea messages;
    private final JButton btnEnable;

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            server.closeServer();
        }
        super.processWindowEvent(e);
    }

    public ServerViewWindow(String title, Server server, int leftPoint) throws HeadlessException {
        super(title);
        this.server = server;
        server.setView(this);

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
                    server.changeStatus();
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

    @Override
    public void showMessage(String message) {
        this.messages.append(message);
    }

    @Override
    public void setStatus(boolean enable) {
        if(enable)
            btnEnable.setText("Disable");
        else btnEnable.setText("Enable");
    }

    public int getLeftPoint() {
        return this.getX();
    }

    public void run(){
        this.setVisible(true);
    }
}
