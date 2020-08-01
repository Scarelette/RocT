package com.happy.gui;

import javax.swing.*;
import java.awt.*;

public class ClientStart {
    private JFrame jf = new JFrame();
    private Box vertical = Box.createVerticalBox();
    private Color white = new Color(246, 243, 238);
    private Color black = new Color(0,0,14);
    private Color yellow = new Color(240, 202, 95);
    private Font wFont = new Font("Droid Sans Mono Slashed",0,16);
    private Font yFont = new Font("Droid Sans Mono Slashed",1,18);

    public void showUI() {
        jf.setSize(350,540);    //窗体大小
        jf.setDefaultCloseOperation(3);    //可以退出
        jf.setLocationRelativeTo(null);    //相对屏幕居中
        jf.setTitle("RocT");              //窗体名字
        jf.setLayout(new FlowLayout());
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pic/RocTPic.png"));
//        ImageIcon icon = new ImageIcon();
//        icon.setImage(image);
//        JLabel jla = new JLabel(icon);
        ImageIcon icon = new ImageIcon("/Users/scarelette/Documents/RocTServer2/src/main/java/com/happy/pic/RocT.png");
        icon.setImage(icon.getImage().getScaledInstance(80, 70,
                Image.SCALE_DEFAULT));
        JLabel jla = new JLabel(icon);
        jla.setAlignmentX(0.5F);

        JLabel intranetLabel = new JLabel("RocT-Intranet");
        intranetLabel.setFont(yFont);
        intranetLabel.setForeground(yellow);
        intranetLabel.setAlignmentX(0.5F);

        JLabel serverAddLabel = new JLabel("Server Address：");
        serverAddLabel.setForeground(white);
        serverAddLabel.setFont(wFont);
        serverAddLabel.setAlignmentX(0.5F);
        JTextField serverAddTextField = new JTextField();
        serverAddTextField.setPreferredSize(new Dimension(250,30));

        JLabel serverPortLabel = new JLabel("Server Port：");
        serverPortLabel.setForeground(white);
        serverPortLabel.setFont(wFont);
        serverPortLabel.setAlignmentX(0.5F);
        JTextField serverPortTextField = new JTextField();
        serverPortTextField.setPreferredSize(new Dimension(250,30));

        JLabel passwordLabel = new JLabel("Password：");
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(250,30));
        passwordLabel.setForeground(white);
        passwordLabel.setFont(wFont);
        passwordLabel.setAlignmentX(0.5F);

        JPanel jPanel = new JPanel();
        JButton jb = new JButton("START");
//        jb.setSize(200,40);
        jb.setBackground(yellow);
        jb.setPreferredSize(new Dimension(200, 30));
        ClientButtonListener clientButtonListener = new ClientButtonListener(serverPortTextField,serverAddTextField,passwordTextField,jf);
        jb.addActionListener(clientButtonListener);
        jb.setAlignmentX(0.5F);
        jPanel.add(jb);
//        jla.setAlignmentX(0.6F);
        vertical.add(Box.createVerticalStrut(60));
//        vertical.add(Box.createHorizontalStrut(jf.getWidth() / 2 - 50));
        vertical.add(jla);
        vertical.add(Box.createVerticalStrut(5));
        vertical.add(intranetLabel);
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(serverAddLabel);
        vertical.add(Box.createVerticalStrut(5));
        vertical.add(serverAddTextField);
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(serverPortLabel);
        vertical.add(Box.createVerticalStrut(5));
        vertical.add(serverPortTextField);
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(passwordLabel);
        vertical.add(Box.createVerticalStrut(5));
        vertical.add(passwordTextField);
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(jb);

        jf.add(vertical, BorderLayout.CENTER);
        jf.setVisible(true);
        jf.getContentPane().setBackground(black);

    }

    public static void main(String args[]){
        ClientStart clientStart = new ClientStart();
        clientStart.showUI();
    }
}
