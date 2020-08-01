package com.happy.gui;

import com.happy.Handler.RocTClientHandler;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class ClientProxyListener implements ActionListener {

    private JTextField proxyPort;
    private JTextField proxyAdd;
    private JTextField remotePort;
    //private JTextField httpsPort;
    private JFrame jFrame;
    private RocTClientHandler rocTClientHandler;

    /**
     * 添加静态链表，用于存储server端运行结果
     */
    static LinkedList<String> results = new LinkedList<String>();

    public void setting(JTextField proxyPort, JTextField proxyAdd, JTextField remotePort,JFrame jFrame, RocTClientHandler rocTClientHandler,LinkedList<String> resultsDemo) {
        this.proxyPort = proxyPort;
        this.proxyAdd = proxyAdd;
        this.remotePort = remotePort;
        //this.httpsPort = httpsPort;
        this.jFrame = jFrame;
        this.rocTClientHandler = rocTClientHandler;
        results = resultsDemo;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("clicking...");
        try {
			boolean result = checkInput();
			if(!result) {
				return;
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {			
			e1.printStackTrace();
			return;
		}
        int remotePort = Integer.valueOf(this.remotePort.getText());
        String proxyAdd = this.proxyAdd.getText();
        String proxyPort = this.proxyPort.getText();

        rocTClientHandler.processBind(remotePort, proxyAdd, proxyPort);
    }

    public boolean checkInput() throws InterruptedException, IOException {

        String proxyAddress = this.proxyAdd.getText();
        if (proxyAddress.equals("")) {
            System.out.println("proxy_addr cannot be null");
            JOptionPane.showMessageDialog(null,"proxy_addr cannot be null");
            return false;
        }
        String proxyPort = this.proxyPort.getText();
        if (proxyPort.equals("")) {
            System.out.println("proxy_port cannot be null");
            JOptionPane.showMessageDialog(null,"proxy_port cannot be null");
            return false;
        }
        String remotePort = this.remotePort.getText();
        if (remotePort.equals("") ) {
            System.out.println("remote_port cannot be null");
            JOptionPane.showMessageDialog(null,"remote_port cannot be null");
            return false;
        }
        return true;

    }
}


