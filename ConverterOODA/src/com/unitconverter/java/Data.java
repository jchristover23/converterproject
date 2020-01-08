package com.unitconverter.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;

public class Data extends JFrame {


	private JPanel DataPane;
	private JTextField DataField1;
	private JTextField DataField2;
	History history = new History();

	/**
	 * Launch the application.
	 */
	public static void DataMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data frame = new Data();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Data() {
		
		
		setTitle("Data Converter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		DataPane = new JPanel();
		DataPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(DataPane);
		DataPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Converter");
		lblNewLabel.setBounds(10, 10, 135, 13);
		DataPane.add(lblNewLabel);
		
		DataField1 = new JTextField();
		DataField1.setBounds(10, 33, 153, 19);
		DataPane.add(DataField1);
		DataField1.setColumns(10);
		
		DataField2 = new JTextField();
		DataField2.setEditable(false);
		DataField2.setBounds(10, 97, 153, 19);
		DataPane.add(DataField2);
		DataField2.setColumns(10);
		
		JComboBox DataCombo1 = new JComboBox();
		DataCombo1.setModel(new DefaultComboBoxModel(new String[] {"bit(b)", "byte(B)"}));
		DataCombo1.setBounds(173, 32, 78, 21);
		DataPane.add(DataCombo1);
		
		JComboBox DataCombo2 = new JComboBox();
		DataCombo2.setModel(new DefaultComboBoxModel(new String[] {"bit(b)", "byte(B)"}));
		DataCombo2.setBounds(173, 96, 78, 21);
		DataPane.add(DataCombo2);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DataUnit1 = (String)DataCombo1.getSelectedItem().toString();
				String DataUnit2 = (String)DataCombo2.getSelectedItem().toString();
				double result = Double.parseDouble(DataField1.getText());
				
				if (DataUnit1 == "bit(b)" && DataUnit2 == "byte(B)") {
					result /= 8; 
					DataField2.setText(String.valueOf(result));
					String summary = (DataField1.getText() + " " + DataUnit1 + " -> " + DataField2.getText() + " " + DataUnit2);
					history.DataHistory.add(summary);
					System.out.println(summary);
				}
				
					
					else if (DataUnit1 == "byte(B)" && DataUnit2 == "bit(b)") {
						result *= 8; 
						DataField2.setText(String.valueOf(result));
						String summary = (DataField1.getText() + " " + DataUnit1 + " -> " + DataField2.getText() + " " + DataUnit2);
						history.DataHistory.add(summary);
						
					}
					
					else {
						DataField2.setText("Unit cannot be the same!");
					}
				}
				
				
		});
		convertButton.setBounds(10, 136, 85, 21);
		DataPane.add(convertButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 74, 45, 13);
		DataPane.add(resultLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		backButton.setBounds(341, 232, 85, 21);
		DataPane.add(backButton);
		
		JList historyList = new JList(history.DataHistory.toArray());
		historyList.setBounds(261, 33, 165, 189);
		DataPane.add(historyList);
		
		JLabel lblNewLabel_1 = new JLabel("Converted Data History");
		lblNewLabel_1.setBounds(261, 10, 165, 13);
		DataPane.add(lblNewLabel_1);
	}
}
