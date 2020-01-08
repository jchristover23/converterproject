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

public class Temperature extends JFrame {

	private JPanel tempPane;
	private JTextField tempField1;
	private JTextField tempField2;

	/**
	 * Launch the application.
	 */
	public static void TemperatureMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperature frame = new Temperature();
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
	public Temperature() {
		setTitle("Temperature Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		tempPane = new JPanel();
		tempPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tempPane);
		tempPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperature Converter");
		lblNewLabel.setBounds(10, 10, 135, 13);
		tempPane.add(lblNewLabel);
		
		tempField1 = new JTextField();
		tempField1.setBounds(10, 33, 153, 19);
		tempPane.add(tempField1);
		tempField1.setColumns(10);
		
		tempField2 = new JTextField();
		tempField2.setEditable(false);
		tempField2.setBounds(10, 97, 153, 19);
		tempPane.add(tempField2);
		tempField2.setColumns(10);
		
		JComboBox tempCombo1 = new JComboBox();
		tempCombo1.setModel(new DefaultComboBoxModel(new String[] {"C", "F"}));
		tempCombo1.setBounds(173, 32, 45, 21);
		tempPane.add(tempCombo1);
		
		JComboBox tempCombo2 = new JComboBox();
		tempCombo2.setModel(new DefaultComboBoxModel(new String[] {"F", "C"}));
		tempCombo2.setBounds(173, 96, 45, 21);
		tempPane.add(tempCombo2);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempUnit1 = (String)tempCombo1.getSelectedItem().toString();
				String tempUnit2 = (String)tempCombo2.getSelectedItem().toString();
				
				if (tempUnit1 == "C" && tempUnit2 == "F") {
					double result = Double.parseDouble(tempField1.getText());
					result = (result * 1.8) + 32; 
					tempField2.setText(String.valueOf(result)); }
					
					else if (tempUnit1 == "F" && tempUnit2 == "C") {
						double result = Double.parseDouble(tempField1.getText());
						result = (result - 32) / 1.8; 
						tempField2.setText(String.valueOf(result));
					}
					
					else {
						tempField2.setText("Unit cannot be the same!");
					}
				}
				
				
		});
		convertButton.setBounds(10, 136, 85, 21);
		tempPane.add(convertButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 74, 45, 13);
		tempPane.add(resultLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		backButton.setBounds(341, 232, 85, 21);
		tempPane.add(backButton);
	}

}
