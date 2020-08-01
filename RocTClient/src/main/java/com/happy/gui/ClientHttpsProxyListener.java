package com.happy.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.happy.Handler.RocTClientHandler;

class ClientHttpsProxyListener implements ActionListener {
    static RocTClientHandler rocTClientHandler;
    private JTextField portTextField;
    private JButton button;
    private ImageIcon image = new ImageIcon("/Users/scarelette/Documents/RocTClient/src/main/java/com/happy/pic/bianji.png");

    public ClientHttpsProxyListener(RocTClientHandler rocTClientHandlerDemo, JTextField portTextField, JButton button) {
        rocTClientHandler = rocTClientHandlerDemo;
        this.portTextField = portTextField;
        this.button = button;
        image.setImage(image.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT ));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int port = Integer.valueOf(portTextField.getText());
        portTextField.setEditable(false);
        rocTClientHandler.setHttpsProxy(port);
        button.setIcon(image);
        button.setEnabled(false);
    }
}
