package com.happy.gui;

import javax.swing.*;
import java.awt.*;

public class ServerStarter extends JFrame{

    private JFrame jf = new JFrame();
    private Box horizontalIcon = Box.createHorizontalBox();
    private Box horizontalBtn = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();
    private Color white = new Color(246, 243, 238);
    private Color black = new Color(38, 38, 38);
    private Color yellow = new Color(240, 202, 95);

    public void showUI() {
        jf.setSize(310,590);    //窗体大小
        jf.setDefaultCloseOperation(3);    //可以退出
        jf.setLocationRelativeTo(null);    //相对屏幕居中
        jf.setTitle("RocT");              //窗体名字
        jf.setLayout(new FlowLayout());

//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pic/RocTPic.png"));
//        ImageIcon icon = new ImageIcon();
//        icon.setImage(image);
        ImageIcon icon = new ImageIcon("src/main/java/com/happy/pic/1.jpg");
        icon.setImage(icon.getImage().getScaledInstance(210, 200,
                Image.SCALE_DEFAULT));
        JLabel jla = new JLabel(icon);
        jla.setAlignmentX(0.5F);
        JLabel serverPortLabel = new JLabel("Server Port");
        serverPortLabel.setForeground(white);
        serverPortLabel.setFont(new Font("Droid Sans Mono Slashed",0,16));
        serverPortLabel.setAlignmentX(0.5F);
        JTextField serverPortTextField = new JTextField();
        serverPortTextField.setPreferredSize(new Dimension(250,30));
//        serverPortTextField.setBorder(new RoundBorder());
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(white);
        passwordLabel.setFont(new Font("Droid Sans Mono Slashed",0,16));
        passwordLabel.setAlignmentX(0.5F);
        JPasswordField passwordTextField = new JPasswordField();
//        passwordTextField.setBorder(new RoundBorder());
        passwordTextField.setPreferredSize(new Dimension(250,30));

        JButton jb = new JButton();
        jb.setText("Start");
        jb.setPreferredSize(new Dimension(250, 30));
        ServerButtonListener serverButtonListener = new ServerButtonListener(serverPortTextField,passwordTextField,jf);
        jb.addActionListener(serverButtonListener);
        jb.setAlignmentX(0.5F);
        jb.setBackground(yellow);
//        jb.setOpaque(true);
//        jb.setContentAreaFilled(false);
//        jb.setMargin(new Insets(0, 0, 0, 0));
//        jb.setFocusPainted(false);
//        jb.setBorderPainted(false);
//        jb.setBorder(null);

//        JPanel btnPanel = new JPanel();
//        JButton jb1 = new JButton("Bind");
//        jb1.setBackground(Color.YELLOW);
//        btnPanel.add(jb1);
//        jla.setAlignmentX(0.6F);
        vertical.add(Box.createVerticalStrut(60));
//        vertical.add(Box.createHorizontalStrut(jf.getWidth() / 2 - 50));
        vertical.add(jla);
        vertical.add(Box.createVerticalStrut(60));
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
//        jf.pack();
        jf.setVisible(true);
        jf.getContentPane().setBackground(black);

    }

    public static void main(String args[]){
        ServerStarter serverStart = new ServerStarter();
        serverStart.showUI();
    }
}
