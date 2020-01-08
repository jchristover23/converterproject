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

public class Length extends JFrame {

	private JPanel lengthPane;
	private JTextField lengthField1;
	private JTextField lengthField2;

	/**
	 * Launch the application.
	 */
	public static void LengthMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Length frame = new Length();
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
	public Length() {
		setTitle("Length Converter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		lengthPane = new JPanel();
		lengthPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lengthPane);
		lengthPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Length Converter");
		lblNewLabel.setBounds(10, 10, 135, 13);
		lengthPane.add(lblNewLabel);
		
		lengthField1 = new JTextField();
		lengthField1.setBounds(10, 33, 153, 19);
		lengthPane.add(lengthField1);
		lengthField1.setColumns(10);
		
		lengthField2 = new JTextField();
		lengthField2.setEditable(false);
		lengthField2.setBounds(10, 97, 153, 19);
		lengthPane.add(lengthField2);
		lengthField2.setColumns(10);
		
		JComboBox lengthCombo1 = new JComboBox();
		lengthCombo1.setModel(new DefaultComboBoxModel(new String[] {"km", "m", "cm"}));
		lengthCombo1.setBounds(173, 32, 45, 21);
		lengthPane.add(lengthCombo1);
		
		JComboBox lengthCombo2 = new JComboBox();
		lengthCombo2.setModel(new DefaultComboBoxModel(new String[] {"cm", "m", "km"}));
		lengthCombo2.setBounds(173, 96, 45, 21);
		lengthPane.add(lengthCombo2);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lengthUnit1 = (String)lengthCombo1.getSelectedItem().toString();
				String lengthUnit2 = (String)lengthCombo2.getSelectedItem().toString();
				
				if (lengthUnit1 == "km" && lengthUnit2 == "m") {
					double result = Double.parseDouble(lengthField1.getText());
					result = result * 1000; 
					lengthField2.setText(String.valueOf(result)); }
					
					else if (lengthUnit1 == "km" && lengthUnit2 == "cm") {
						double result = Double.parseDouble(lengthField1.getText());
						result = result * 100000; 
						lengthField2.setText(String.valueOf(result));
					}
				
					else if (lengthUnit1 == "m" && lengthUnit2 == "km") {
						double result = Double.parseDouble(lengthField1.getText());
						result = result / 1000; 
						lengthField2.setText(String.valueOf(result));
					}
				
					else if (lengthUnit1 == "m" && lengthUnit2 == "cm") {
						double result = Double.parseDouble(lengthField1.getText());
						result = result * 100; 
						lengthField2.setText(String.valueOf(result));
					}
				
					else if (lengthUnit1 == "cm" && lengthUnit2 == "km") {
						double result = Double.parseDouble(lengthField1.getText());
						result = result / 100000; 
						lengthField2.setText(String.valueOf(result));
					}
				
					else if (lengthUnit1 == "cm" && lengthUnit2 == "m") {
						double result = Double.parseDouble(lengthField1.getText());
						result = result / 100; 
						lengthField2.setText(String.valueOf(result));
					}
					
					else {
						lengthField2.setText("Unit cannot be the same!");
					}
				}
				
				
		});
		convertButton.setBounds(10, 136, 85, 21);
		lengthPane.add(convertButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 74, 45, 13);
		lengthPane.add(resultLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		backButton.setBounds(341, 232, 85, 21);
		lengthPane.add(backButton);
	}

}
