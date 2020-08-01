package com.happy.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class RowDeleteDemo extends JFrame
{
    private JPanel contentPane;
    private JTable table;
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        RowDeleteDemo frame = new RowDeleteDemo();
        frame.setVisible(true);
    }
    /**
     * Create the frame.
     */
    public RowDeleteDemo()
    {
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowActivated(WindowEvent e)
            {
                do_this_windowActivated(e);
            }
        });
//        setTitle("图书信息表");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,200);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        JPanel panel=new JPanel();
        contentPane.add(panel,BorderLayout.SOUTH);
        JButton button=new JButton("Delete");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                do_deleteButton_actionPerformed(e);
            }
        });
        panel.add(button);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                do_addButton_actionPerformed(actionEvent);
            }
        });
        panel.add(addButton);
        JScrollPane scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);
        table=new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);
    }
    protected void do_this_windowActivated(WindowEvent e)
    {
        DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"Remote Port","Proxy Address","Proxy Port"});    //设置表头
        tableModel.addRow(new Object[]{"1010","192.178.0.1","8080"});    //增加列
        tableModel.addRow(new Object[]{"1015","192.178.0.2","8080"});
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
    }

    protected void do_deleteButton_actionPerformed(ActionEvent e)
    {
        DefaultTableModel model=(DefaultTableModel) table.getModel();    //获得表格模型
        int[] selectedRows=table.getSelectedRows();
        for(int i=selectedRows[0];i<selectedRows.length;i++)
        {
            model.removeRow(selectedRows[0]);
        }
        table.setModel(model);
    }

    protected void do_addButton_actionPerformed(ActionEvent e)
    {
        DefaultTableModel model=(DefaultTableModel) table.getModel();    //获得表格模型
        model.addRow(new Vector<>());
        table.setModel(model);
    }
}