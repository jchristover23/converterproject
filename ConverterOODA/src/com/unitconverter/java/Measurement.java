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

public class Measurement extends JFrame {


	private JPanel MeasurementPane;
	private JTextField MeasurementField1;
	private JTextField MeasurementField2;
	History history = new History();

	/**
	 * Launch the application.
	 */
	public static void MeasurementMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Measurement frame = new Measurement();
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
	public Measurement() {
		
		
		setTitle("Measurement Converter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MeasurementPane = new JPanel();
		MeasurementPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MeasurementPane);
		MeasurementPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Measurement Converter");
		lblNewLabel.setBounds(10, 10, 135, 13);
		MeasurementPane.add(lblNewLabel);
		
		MeasurementField1 = new JTextField();
		MeasurementField1.setBounds(10, 33, 153, 19);
		MeasurementPane.add(MeasurementField1);
		MeasurementField1.setColumns(10);
		
		MeasurementField2 = new JTextField();
		MeasurementField2.setEditable(false);
		MeasurementField2.setBounds(10, 97, 153, 19);
		MeasurementPane.add(MeasurementField2);
		MeasurementField2.setColumns(10);
		
		JComboBox MeasurementCombo1 = new JComboBox();
		MeasurementCombo1.setModel(new DefaultComboBoxModel(new String[] {"Kilo", "Mega", "Giga"}));
		MeasurementCombo1.setBounds(173, 32, 78, 21);
		MeasurementPane.add(MeasurementCombo1);
		
		JComboBox MeasurementCombo2 = new JComboBox();
		MeasurementCombo2.setModel(new DefaultComboBoxModel(new String[] {"Kilo", "Mega", "Giga"}));
		MeasurementCombo2.setBounds(173, 96, 78, 21);
		MeasurementPane.add(MeasurementCombo2);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MeasurementUnit1 = (String)MeasurementCombo1.getSelectedItem().toString();
				String MeasurementUnit2 = (String)MeasurementCombo2.getSelectedItem().toString();
				double result = Double.parseDouble(MeasurementField1.getText());
				
				if (MeasurementUnit1 == "bit(b)" && MeasurementUnit2 == "byte(B)") {
					result /= 8; 
					MeasurementField2.setText(String.valueOf(result));
					String summary = (MeasurementField1.getText() + " " + MeasurementUnit1 + " -> " + MeasurementField2.getText() + " " + MeasurementUnit2);
					history.MeasurementHistory.add(summary);
					System.out.println(summary);
				}
				
					
					else if (MeasurementUnit1 == "byte(B)" && MeasurementUnit2 == "bit(b)") {
						result *= 8; 
						MeasurementField2.setText(String.valueOf(result));
						String summary = (MeasurementField1.getText() + " " + MeasurementUnit1 + " -> " + MeasurementField2.getText() + " " + MeasurementUnit2);
						history.MeasurementHistory.add(summary);
						
					}
					
					else {
						MeasurementField2.setText("Unit cannot be the same!");
					}
				}
				
				
		});
		convertButton.setBounds(10, 136, 85, 21);
		MeasurementPane.add(convertButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 74, 45, 13);
		MeasurementPane.add(resultLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		backButton.setBounds(341, 232, 85, 21);
		MeasurementPane.add(backButton);
		
		JList historyList = new JList(history.MeasurementHistory.toArray());
		historyList.setBounds(261, 33, 165, 189);
		MeasurementPane.add(historyList);
		
		JLabel lblNewLabel_1 = new JLabel("Converted Measurement History");
		lblNewLabel_1.setBounds(261, 10, 165, 13);
		MeasurementPane.add(lblNewLabel_1);
	}
}
